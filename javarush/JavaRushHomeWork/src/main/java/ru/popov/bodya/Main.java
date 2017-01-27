package ru.popov.bodya;

public class Main {

    static int a;

    static {
        a = 3;
    }
    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(b);
    }

    static int b = a;
    static {
        a = 2;
    }

}
