package basic;

public class MainWithThreads {
    public static void main(String[] args) throws InterruptedException {
        final TextLoader fileTextLoader = new MockLoader("textFromFile");
        final TextLoader webTextLoader = new MockLoader("textFromWeb");
        final long before = System.currentTimeMillis();
        final Thread fileTextLoaderThread = new Thread() {
            @Override
            public void run() {
                System.out.println(fileTextLoader.loadText());
            }
        };

        final Thread webTextLoaderThread = new Thread() {
            @Override
            public void run() {
                System.out.println(webTextLoader.loadText());
            }
        };

        fileTextLoaderThread.start();
        webTextLoaderThread.start();

        fileTextLoaderThread.join();
        webTextLoaderThread.join();
        final long after = System.currentTimeMillis();
        System.out.println("time delta: " + (after - before) / 1000);

    }
}
