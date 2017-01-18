package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(reader.readLine().trim());
             BufferedReader finalReader = new BufferedReader(fileReader)) {
            List<Integer> numbers = new ArrayList<>();
            String tmp;
            while ((tmp = finalReader.readLine()) != null) {
                int number = Integer.parseInt(tmp);
                if ((number % 2 == 0)) {
                    numbers.add(number);
                }
            }
            Collections.sort(numbers);
            for (int i : numbers) {
                System.out.println(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
