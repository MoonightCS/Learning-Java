package tasks;

import java.util.stream.IntStream;

public class SummThread extends Thread {

    private int sum = 0;
    private final int[] arr;

    SummThread(final int[] toSumm) {
        this.arr = toSumm;
    }

    @Override
    public void run() {
       sum = IntStream.of(arr).sum();
    }

    public int getResult() {
        return sum;
    }

}
