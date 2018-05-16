package ru.popov.bodya.chapter2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Dots {

    private static class Pair {
        private final int start;
        private final int end;

        private Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();
        final List<Pair> pairList = new ArrayList<>(n);
        int start, end;
        for (int i = 0; i < n; i++) {
            start = scanner.nextInt();
            end = scanner.nextInt();
            pairList.add(new Pair(start, end));
        }

        pairList.sort(Comparator.comparingInt(o -> o.end));

        final List<Integer> currentDots = new ArrayList<>();
        int currentDotIndex = -1;

        for (final Pair pair : pairList) {
            if (pair.start > currentDotIndex) {
                currentDotIndex = pair.end;
                currentDots.add(currentDotIndex);
            }
        }

        System.out.println(currentDots.size());
        currentDots.forEach(integer -> System.out.print(integer + " "));
    }

    public static void main(String[] args) {
        new Dots().run();
    }

}
