package ru.popov.bodya;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static ru.popov.bodya.Operations.transfer;

public class Terminal {

    /**
     * Диагностируем дедлок - jps, затем jstack. UI tool - jconsole
     */

    public static void main(String[] args) {
        final Account accountA = new Account(300);
        final Account accountB = new Account(300);

        checkingThreadPool(accountA, accountB);
//        checkingTransferWork(accountA, accountB);

    }

    private static void checkingThreadPool(Account accountA, Account accountB) {
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("available processors: " + nThreads);
        ExecutorService service = Executors.newFixedThreadPool(nThreads);

        for (int i = 0; i < 100000; i++) {
            service.submit(new Transfer(accountA, accountB, 5));
            service.submit(new Transfer(accountB, accountA, 5));
        }
        service.shutdown();

    }

    private static void checkingTransferWork(Account accountFrom, Account accountTo) {
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> transfer(accountFrom, accountTo, 5)).start();
            new Thread(() -> transfer(accountTo, accountFrom, 5)).start();
        }
    }
}
