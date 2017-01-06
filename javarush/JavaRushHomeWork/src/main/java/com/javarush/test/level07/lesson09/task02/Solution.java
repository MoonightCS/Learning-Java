package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* Слова в обратном порядке
Введи с клавиатуры 5 слов в список строк. Удали 3 - ий элемент списка, и выведи оставшиеся элементы в обратном порядке.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine().trim());
        }
        strings.remove(2);
//        ListIterator<String> li = strings.listIterator(strings.size());
//        while(li.hasPrevious()) {
//            System.out.println(li.previous());
//        }
        for (int i = strings.size() - 1; i >= 0; i--) {
            System.out.println(strings.get(i));
        }

    }
}
