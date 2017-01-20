package ru.popov.bodya;

public class Main {
    public int a = 5;

    public int b = getSum();

    public int c = getSum() - a - b;

    public int getSum() {
        return a + b + c;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.a);
        System.out.println(main.b);
        System.out.println(main.c);
    }

}
