package ru.popov.bodya;

import java.util.concurrent.locks.Lock;

/**
 * Диагностируем дедлок - jps, затем jstack. UI tool - jconsole
 */

public class Operations {

    public static void main(String[] args) {
        final Account accountA = new Account(300);
        final Account accountB = new Account(300);

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> transfer(accountA, accountB, 5)).start();
            new Thread(() -> transfer(accountB, accountA, 5)).start();
        }

    }

    /**
     * Конечно, здесь есть вероятность, что hashcode у sender и receive одинаковые + и хэшкоды у их локов тоже одинаковые.
     * Так как метод учебный, данный случай не рассматриваю. Безусловно, можно было бы ввести id у аккаунта и решить
     * проблему без хэширования, но решил рассмотреть случай без него
     */

    private static void transfer(final Account sender, final Account receiver, int amount) {

        System.out.println("transfer started with sender" + sender + "on Thread" + Thread.currentThread().getName());
        int senderLockHash = sender.getLock().hashCode();
        int receiverLockHash = receiver.getLock().hashCode();

        Lock first;
        Lock second;


        if (senderLockHash == receiverLockHash) {
            first = sender.hashCode() > receiver.hashCode() ? sender.getLock() : receiver.getLock();
            second = receiver.hashCode() > sender.hashCode() ? receiver.getLock() : sender.getLock();
        } else {
            first = senderLockHash > receiverLockHash ? sender.getLock() : receiver.getLock();
            second = receiverLockHash > senderLockHash ? receiver.getLock() : sender.getLock();
        }

        first.lock();
        try {
            second.lock();
            try {
                if (sender.getBalance() < amount) {
                    throw new InsufficientFundsException();
                }
                sender.withdraw(amount);
                receiver.deposit(amount);
            } finally {
                second.unlock();
            }
        } finally {
            first.unlock();
        }


    }
}
