package tasks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxInArray {

    public static void main(String... args) throws Exception {
        testArray(new Integer[0], 0);
        testArray(new Integer[]{1, 4, 10, 2}, 10);
        testArray(new Integer[]{1, 4, -10, 2}, 4);
        testArray(new Integer[]{1}, 1);
    }

    private static void testArray(final Integer[] inputArray, final int expectedResult) {
        final int actualResult = new MaxFinder(inputArray).call();
        if (actualResult != expectedResult) {
            throw new RuntimeException(
                    String.format(
                            "Actual max: %d, expected max: %d",
                            actualResult,
                            expectedResult));
        }
    }

    private static class MaxFinder implements Callable<Integer> {

        private final Integer[] array;

        @Override
        public Integer call() {
            if (array.length == 0)
                return 0;
            else
                return Stream.of(array).max(Integer::compareTo).get();
        }


        public MaxFinder(Integer[] array) {
            this.array = array;
        }
    }

}


