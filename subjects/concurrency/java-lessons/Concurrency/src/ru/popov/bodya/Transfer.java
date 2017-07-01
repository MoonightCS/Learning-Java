package ru.popov.bodya;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class Transfer implements Callable<Boolean> {

    private CountDownLatch countDownLatch;
    private Account accountFrom;
    private Account accountTo;
    private int amount;

    public Transfer(CountDownLatch countDownLatch, Account accountFrom, Account accountTo, int amount) {
        this.countDownLatch = countDownLatch;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws InsufficientFundsException, InterruptedException {
        System.out.println("Waiting to start");
        countDownLatch.await();
        Operations.transfer(accountFrom, accountTo, amount);
        return true;
    }
}
