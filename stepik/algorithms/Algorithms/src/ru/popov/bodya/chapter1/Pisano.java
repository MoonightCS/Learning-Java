package ru.popov.bodya.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pisano {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final long n = scanner.nextLong();
        final long m = scanner.nextLong();
        System.out.println(computeFibonacciPisano(n, m));
    }

    private static long computeFibonacciPisano(long n, long m) {
        final List<Long> pisanoPeriodValues = new ArrayList<>();
        pisanoPeriodValues.add(0L);
        pisanoPeriodValues.add(1L);
        int i = 0;

        while (!(i > 0 && pisanoPeriodValues.get(i) == 0 && pisanoPeriodValues.get(i + 1) == 1)) {
            final long a = pisanoPeriodValues.get(i) % m;
            final long b = pisanoPeriodValues.get(i + 1) % m;
            final long sum = (a + b) % m;
            pisanoPeriodValues.add(sum);
            i++;
        }
        final long index = n % i;
        return pisanoPeriodValues.get((int) index);
    }
}
