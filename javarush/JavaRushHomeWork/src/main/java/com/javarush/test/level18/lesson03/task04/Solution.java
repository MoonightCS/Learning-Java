package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> countsOfBytes = new HashMap<>();
        int n;
        int minCount = inputStream.available();

        while (inputStream.available() > 0) {
            n = inputStream.read();
            int newValue;
            if (countsOfBytes.containsKey(n)) {
                newValue = countsOfBytes.get(n) + 1;
                countsOfBytes.put(n, newValue);
            } else {
                countsOfBytes.put(n, 1);
                newValue = 1;
            }
            if (newValue < minCount) {
                minCount = newValue;
            }
        }
        for (Map.Entry<Integer, Integer> entry : countsOfBytes.entrySet()) {
            if (entry.getValue() == minCount) {
                System.out.println(entry.getKey());
            }
        }
        reader.close();
        inputStream.close();
    }
}
