package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int negativeCount = 0;
        int positiveCount = 0;
        for (int i = 0; i < 3; i++) {
            int number = Integer.parseInt(reader.readLine().trim());
            if (number > 0)
                positiveCount++;
            else if (number < 0)
                negativeCount++;
        }
        System.out.printf("количество отрицательных чисел: %d\n", negativeCount);
        System.out.printf("количество положительных чисел: %d\n", positiveCount);

    }
}
