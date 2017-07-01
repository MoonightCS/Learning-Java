package ru.popov.bodya;

import java.util.concurrent.Callable;

public class Transfer implements Callable<Boolean> {

    private Account accountFrom;
    private Account accountTo;
    private int amount;

    public Transfer(Account accountFrom, Account accountTo, int amount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws InsufficientFundsException {
        Operations.transfer(accountFrom, accountTo, amount);
        return true;
    }
}
