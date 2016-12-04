package basic;

public class Main {

    public static void main(String[] args) {
        final TextLoader fileTextLoader = new MockLoader("textFromFile");
        final TextLoader webTextLoader = new MockLoader("textFromWeb");
        final long before = System.currentTimeMillis();
        fileTextLoader.loadText();
        webTextLoader.loadText();
        final long after = System.currentTimeMillis();
        System.out.println("time delta: " + (after - before) / 1000);

    }
}
