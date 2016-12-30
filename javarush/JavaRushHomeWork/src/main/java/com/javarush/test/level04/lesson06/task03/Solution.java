package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int a = Integer.parseInt(reader.readLine().trim());
        final int b = Integer.parseInt(reader.readLine().trim());
        final int c = Integer.parseInt(reader.readLine().trim());
<<<<<<< HEAD
        List<Integer> list = new ArrayList<>(Arrays.asList(a, b, c));
=======
        List<Integer> list = new ArrayList<>(Arrays.asList(a,b,c));
>>>>>>> f8098f0ca04e1f532c2a86ead11d20ec15c27805
        Collections.sort(list);
        Collections.reverse(list);
        for (int i : list) {
            System.out.printf("%d\n", i);
        }

    }


}
