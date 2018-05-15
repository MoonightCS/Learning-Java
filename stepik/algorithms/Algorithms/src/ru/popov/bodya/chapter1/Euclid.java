package ru.popov.bodya.chapter1;

import java.util.Scanner;

public class Euclid {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        System.out.println(nod(a, b));

    }

    private static int nod(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return a >= b ? nod(a % b, b) : nod(a, b % a);
    }
}
