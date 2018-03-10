package ru.popov.bodya.stream;

import ru.popov.bodya.forkjoin.Commons;

import java.util.Arrays;

public class StreamUsage {
    public static void main(String[] args) {

        int[] array = Commons.prepareArray();
        long startTime = System.currentTimeMillis();
        double sum = Arrays.stream(array)
                .parallel()
                .mapToDouble(Commons::function)
                .sum();
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum);
        System.out.println("time = " + (end - startTime) + "ms");
    }
}
