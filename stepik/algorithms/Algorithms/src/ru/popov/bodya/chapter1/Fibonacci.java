package ru.popov.bodya.chapter1;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(final int n) {
        final int[] fiboValues = new int[n + 1];
        fiboValues[0] = 0;
        fiboValues[1] = 1;
        for (int i = 2; i <= n; i++) {
            fiboValues[i] = fiboValues[i - 1] + fiboValues[i - 2];
        }
        return fiboValues[n];
    }
}
