package com.javarush.test.level04.lesson10.task01;

/* 10 чисел
Вывести на экран числа от 1 до 10 используя цикл while.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int i = 1;
        while (i < 11) {
            System.out.printf("%d ", i);
            i++;
        }

    }
}