package ru.popov.bodya;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private int balance;
    private Lock lock;

    public Account(int balance) {
        this.balance = balance;
        lock = new ReentrantLock();
    }

    public void withdraw(int amount) {
        balance -= amount;
        System.out.println("withdraw successful, current balance: " + balance);
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("deposit successful, current balance: " + balance);
    }

    public int getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }
}
