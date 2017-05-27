package com.javarush.task.task25.task2508;

/*
Не валять дурака
Восстанови логику класса TaskManipulator.
 */

public class TaskManipulator implements CustomThreadManipulator, Runnable {

    private Thread thread;

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(0);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
