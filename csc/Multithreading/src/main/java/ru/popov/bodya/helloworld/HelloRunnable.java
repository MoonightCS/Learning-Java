package ru.popov.bodya.helloworld;

public class HelloRunnable implements Runnable
{

    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new HelloRunnable()).start();
            new Thread(() -> System.out.println("Hello from " + Thread.currentThread().getName())).start();
        }


    }
}