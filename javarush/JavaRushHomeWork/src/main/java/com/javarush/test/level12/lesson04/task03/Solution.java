package com.javarush.test.level12.lesson04.task03;

/* Пять методов print с разными параметрами
Написать пять методов print с разными параметрами.
*/

public class Solution {
    public static void main(String[] args) {

    }

    public int print() {
        return 1;
    }

    public int print(int a) {
        return a;
    }

    public int print(int b, int c) {
        return c % b;
    }

    public int print(float d) {
        return (int) d;
    }

    public int print(byte f) {
        return f;
    }
}
