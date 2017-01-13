package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        List<Boolean> status = new ArrayList<>(); // true - string, false - number;
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            if (isNumber(s)) {
                integers.add(Integer.parseInt(s));
                status.add(false);
            } else {
                strings.add(s);
                status.add(true);
            }
        }
        Collections.sort(strings);
        Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0, j = 0, k = 0; i < status.size(); i++) {
            if (status.get(i)) {
                System.out.println(strings.get(j));
                j++;
            } else {
                System.out.println(integers.get(k));
                k++;
            }
        }

    }

    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-')
                    || (!Character.isDigit(c) && c != '-')) {
                return false;
            }
        }
        return true;
    }
}
