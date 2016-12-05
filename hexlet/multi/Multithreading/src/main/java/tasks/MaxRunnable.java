package tasks;

import java.util.stream.IntStream;

public class MaxRunnable implements Runnable {
    private int sum = 0;
    private final int[] arr;

    public MaxRunnable(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        sum = IntStream.of(arr).max().getAsInt();
    }

    public int getResult() {
        return sum;
    }
}
