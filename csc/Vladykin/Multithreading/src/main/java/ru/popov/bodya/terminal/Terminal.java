package ru.popov.bodya.terminal;

public class Terminal {

    public static void main(String[] args) {

        Account account = new Account(100_000);
        System.out.println("Start balance = " + account.getBalance());

        WithdrawThread withdrawThread = new WithdrawThread(account);
        DepositThread depositThread = new DepositThread(account);

        withdrawThread.start();
        depositThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        System.out.println(account.getBalance());

    }

    private static class WithdrawThread extends Thread {
        private final Account account;

        public WithdrawThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.withdraw(1);
            }
        }
    }

    private static class DepositThread extends Thread {
        private final Account account;

        public DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.deposit(1);
            }
        }
    }
}
