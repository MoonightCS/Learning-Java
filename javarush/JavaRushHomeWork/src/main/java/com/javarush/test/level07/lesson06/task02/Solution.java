package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        int max = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine().trim());
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int countChars = list.get(i).length();
            if (countChars > max) {
                max = countChars;
                answer.clear();
                answer.add(list.get(i));
            } else if (countChars == max) {
                answer.add(list.get(i));
            }
        }
        size = answer.size();
        for (int i = 0; i < size; i++) {
            System.out.println(answer.get(i));
        }


    }
}
