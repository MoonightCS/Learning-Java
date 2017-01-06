package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>(Arrays.asList("мама", "мыла", "раму"));
        int size = list.size();
        for (int i = 0; i < 2 * size; i += 2) {
            list.add(i + 1,"именно");
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
