package ru.popov.bodya;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolSample {

    private static final int ARRAY_SIZE = 15;

    private static class Solver extends RecursiveAction {
        private int start, end, result;
        private int array[];

        private Solver(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start == 1) {
                result = array[start];
            } else {
                int mid = (start + end) / 2;
                Solver solver1 = new Solver(array, start, mid);
                Solver solver2 = new Solver(array, mid, end);
                invokeAll(solver1, solver2);
                result = Math.max(solver1.result, solver2.result);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = createArray(ARRAY_SIZE);
        printArray(array);
        int max = findMax(array, Runtime.getRuntime().availableProcessors());
        System.out.println("max = " + max);
    }

    public static int findMax(int[] array, int threadsCount) {
        Solver solver = new Solver(array, 0, array.length);
        ForkJoinPool forkJoinPool = new ForkJoinPool(threadsCount);
        forkJoinPool.invoke(solver);
        return solver.result;
    }

    private static int[] createArray(int arraySize) {
        Random random = new Random();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    private static void printArray(int[] array) {
        System.out.println("array: ");
        for (int elem : array) {
            System.out.println(elem);
        }
        System.out.println("_____________");
    }

}
