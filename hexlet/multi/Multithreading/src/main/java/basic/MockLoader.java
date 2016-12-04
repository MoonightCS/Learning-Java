package basic;

public class MockLoader implements TextLoader {

    private final String str;

    public MockLoader(String str) {
        this.str = str;
    }

    @Override
    public String loadText() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return str;
    }
}
