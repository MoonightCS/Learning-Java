package ru.popov.bodya.sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGeneratorGoodOne {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void nextInt() {
        counter.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> { for (int j = 0; j < 1000; j++) nextInt();});
            thread.start();
            threads.add(thread);
        }
        for (Thread thread: threads) {
            thread.join();
        }
        System.out.println(counter);
    }
}
