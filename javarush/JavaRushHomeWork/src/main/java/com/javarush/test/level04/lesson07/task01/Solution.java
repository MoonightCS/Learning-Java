package com.javarush.test.level04.lesson07.task01;

/* Строка - описание
Ввести с клавиатуры целое число. Вывести на экран его строку-описание следующего вида:
«отрицательное четное число» - если число отрицательное и четное,
«отрицательное нечетное число» - если число отрицательное и нечетное,
«нулевое число» - если число равно 0,
«положительное четное число» - если число положительное и четное,
«положительное нечетное число» - если число положительное и нечетное.
Пример для числа 100:
положительное четное число
Пример для числа -51:
отрицательное нечетное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int number = Integer.parseInt(reader.readLine().trim());
        if (number == 0) {
            System.out.println("нулевое число\n");
            return;
        }
        if (number < 0) {
            System.out.printf("отрицательное ");
        } else {
            System.out.printf("положительное ");
        }
        if (number % 2 == 0) System.out.println("четное число");
        else System.out.println("нечетное число");
    }
}
