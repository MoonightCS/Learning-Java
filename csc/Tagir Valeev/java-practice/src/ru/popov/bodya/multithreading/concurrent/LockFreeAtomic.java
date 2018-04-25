package ru.popov.bodya.multithreading.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

public class LockFreeAtomic {


    private int getAndDouble(AtomicInteger atomicInteger) {
        int cur;
        do {
            cur = atomicInteger.get();
        } while (!atomicInteger.compareAndSet(cur, cur * 2));
        return cur;
    }

    private int getAndDoubleWithLambda(AtomicInteger integer) {
        return integer.getAndUpdate(val -> val * 2);
    }

}
