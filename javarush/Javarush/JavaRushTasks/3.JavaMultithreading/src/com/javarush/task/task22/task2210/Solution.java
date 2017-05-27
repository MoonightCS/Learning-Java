package com.javarush.task.task22.task2210;

/* 
Используя StringTokenizer разделить query на части по разделителю delimiter.

Пример
getTokens("level22.lesson13.task01", ".")

Возвращает
{"level22", "lesson13", "task01"}
*/

import java.util.StringTokenizer;

public class Solution {

    public static String[] getTokens(String query, String delimiter) {

        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] tokens = new String[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            tokens[i++] = stringTokenizer.nextToken();
        }
        return tokens;
    }
}
