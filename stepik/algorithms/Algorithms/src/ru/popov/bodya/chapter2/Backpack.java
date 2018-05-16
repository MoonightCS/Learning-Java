package ru.popov.bodya.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Backpack {

    private static class Jewel {
        private final int cost;
        private final int weight;

        private Jewel(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final List<Jewel> jewels = new ArrayList<>(n);
        double capacity = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            final int cost = scanner.nextInt();
            final int weight = scanner.nextInt();
            jewels.add(new Jewel(cost, weight));
        }

        jewels.sort((o1, o2) -> {
            final double value = ((double) o1.cost) / o1.weight;
            final double comparingValue = ((double) o2.cost) / o2.weight;
            return Double.compare(comparingValue, value);
        });

        int i = 0;
        double result = 0.000;
        while (capacity > 0 && i < jewels.size()) {
            final int weight = jewels.get(i).weight;
            final int cost = jewels.get(i).cost;
            if (capacity >= weight) {
                capacity -= weight;
                result = Double.sum(result,  cost);
            } else {
                final double percent = capacity / weight;
                result = Double.sum(result, percent * cost);
                capacity -= percent * weight;
            }
            i++;
        }
        System.out.printf("%.3f", result);
    }


}
