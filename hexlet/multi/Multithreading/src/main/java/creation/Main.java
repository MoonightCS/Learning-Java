package creation;

import basic.MockLoader;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final long before = System.currentTimeMillis();

        final Thread loader = new TextLoaderThread(new MockLoader("extended thread"));
        loader.start();

        final Runnable runnableLoader = new TextLoaderRunnable(new MockLoader("runnable thread"));
        final Thread thread = new Thread(runnableLoader);
        thread.start();

        final long after = System.currentTimeMillis();
        loader.join();
        thread.join();

        System.out.println("time delta: " + (after - before) / 1000);
    }



}
