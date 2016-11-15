package ru.popov.bodya.terminal2;

public class Terminal2 {
    public static void main(String[] args) throws Exception {
        Account account = new Account();
        new DepositThread(account).start();
        System.out.println("Calling waitAndWithdraw()...");
        account.waitAndWithdraw(50_000_000);
        System.out.println("waitAndWithdraw() finished");
    }

    private static class DepositThread extends Thread {
        private final Account account;

        public DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50_000_000; i++) {
                account.deposit(1);
            }
        }
    }

}
