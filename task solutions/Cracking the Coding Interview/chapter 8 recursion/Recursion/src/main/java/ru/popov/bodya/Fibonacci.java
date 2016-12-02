package ru.popov.bodya;

/**
 *   Write a method to generate the nth Fibonacci number.
 */

public class Fibonacci {

    public int iterFib(int n){
        return iter(0, 1, n);
    }

    private int iter(int a, int b, int n) {
        if (n == 0)
            return a;
        return iter(b, a + b, n - 1);
    }

    public int recFib(int n){
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return recFib(n - 1) + recFib(n - 2);
    }

    public static void main(String[] args) {

        int n = 38;
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.iterFib(n));
        System.out.println(fibonacci.recFib(n));

    }


}
