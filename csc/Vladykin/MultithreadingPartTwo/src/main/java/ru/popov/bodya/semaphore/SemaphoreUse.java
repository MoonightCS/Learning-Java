package ru.popov.bodya.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreUse {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SemThread semThread = new SemThread(semaphore);
            threads.add(semThread);
            semThread.start();
        }
        Thread.sleep(10_000);
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    private static class SemThread extends Thread {

        final Semaphore semaphore;

        public SemThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                runUnsafe();
            } catch (InterruptedException e) {
                System.out.println(this.getName() + "interrupted");
            }
        }

        private void runUnsafe() throws InterruptedException {

            for (; ; ) {
                semaphore.acquire();
                try {
                    System.out.println(getName() + " acquired semaphore ");
                    this.sleep(5000);
                } finally {
                    System.out.println(this.getName() + " releasing semaphore with number ");
                    semaphore.release();
                }
            }
        }
    }
}
