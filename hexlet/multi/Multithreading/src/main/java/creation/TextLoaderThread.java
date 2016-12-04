package creation;

import basic.TextLoader;

public class TextLoaderThread extends Thread {

    private final TextLoader textLoader;

    public TextLoaderThread(TextLoader textLoader) {
        this.textLoader = textLoader;
    }

    @Override
    public void run() {
        System.out.println(textLoader.loadText());
    }
}
