package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> der3 = new ArrayList<>();
        List<Integer> der2 = new ArrayList<>();
        List<Integer> others = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            boolean state = false;
            int number = Integer.parseInt(reader.readLine().trim());
            numbers.add(number);
            if (number % 2 == 0) {
                der2.add(number);
                state = true;
            }
            if (number % 3 == 0) {
                der3.add(number);
                state = true;
            }
            if (!state) {
                others.add(number);
            }
        }
        printList(der3);
        printList(der2);
        printList(others);
    }

    public static void printList(List<Integer> list) {
        for (Integer number : list) {
            System.out.println(number);
        }
    }
}
