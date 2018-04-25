package ru.popov.bodya.multithreading.concurrent;

public class DoerWithMutex {

    private volatile boolean flag = false;

    private void doOnceWithMutex(Runnable action) {
        if (!flag) {
            synchronized (this) {
                if (!flag) {
                    flag = true;
                    action.run();
                }
            }
        }
    }
}
