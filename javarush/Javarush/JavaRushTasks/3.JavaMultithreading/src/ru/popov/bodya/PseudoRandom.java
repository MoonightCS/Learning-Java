package ru.popov.bodya;

public class PseudoRandom {
    public static void main(String[] args) {
        System.out.println(randomIntFromTo(-1, 3));
    }

    public static int randomIntFromTo(int a, int b) {
        return (int) (Math.random() * (b - a + 1)) + a;
    }
}
