package ru.popov.bodya.multithreading.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

public class DoerWithLockFree {

    private final AtomicBoolean flag = new AtomicBoolean(false);

    private void doOnceWithAtomic(Runnable action) {
        if (flag.compareAndSet(false, true)) {
            action.run();
        }
    }

}
