package ru.popov.bodya.multithreading.wait;

public class WaitingRoom {

    private boolean content = false;

    public synchronized void waitForContent() {
        while (!content) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Content has been arrived");
    }

    public synchronized void deliverContent() {
        content = true;
        notifyAll();
    }

}
