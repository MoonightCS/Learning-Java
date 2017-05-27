package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
В программе случайным образом генерируются два целых числа A и В. Нужно вывести все целые числа от A до B включительно,
в порядке возрастания, если A меньше B, или в порядке убывания в противном случае.

Задача реализована с использованием рекурсии.
Иногда в результате работы программы получаем Exception in thread «main« java.lang.StackOverflowError.

Твоя задача: перепиши код без использования рекурсии.
Метод recursion переименуй на getAllNumbersBetween.
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {

        StringBuilder sb = new StringBuilder(String.valueOf(a));

        if (a > b) {
            while (a != b) {
                sb.append(" ");
                sb.append(--a);
            }
        } else {
            while (a != b) {
                sb.append(" ");
                sb.append(++a);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}