package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int a = Integer.parseInt(reader.readLine().trim());
        final int b = Integer.parseInt(reader.readLine().trim());
        final int c = Integer.parseInt(reader.readLine().trim());
        checkEquals(a, b, c);
    }

    private static void checkEquals(int a, int b, int c) {
        if (a == b && a == c) {
            System.out.printf("%d %d %d", a, b, c);
        } else if (a == b || a == c) {
            System.out.printf("%d %d", a, a);
        } else if (b == c)
            System.out.printf("%d %d", b, c);

    }

}