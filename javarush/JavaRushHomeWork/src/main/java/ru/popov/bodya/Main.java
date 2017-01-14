package ru.popov.bodya;

public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = a + 46;
        byte c = (byte) (a * b);
        double f = (char) 1234.15;
        char ch = (char) 1234.15;

        System.out.println((char) 1234.15);
        long d = (long) (a + f / c + b);
        System.out.println(d);
    }

}
