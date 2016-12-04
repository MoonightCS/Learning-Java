package creation;

import basic.TextLoader;

public class TextLoaderRunnable implements Runnable {
    private final TextLoader textLoader;

    public TextLoaderRunnable(TextLoader textLoader) {
        this.textLoader = textLoader;
    }

    @Override
    public void run() {
        System.out.println(textLoader.loadText());
    }
}
