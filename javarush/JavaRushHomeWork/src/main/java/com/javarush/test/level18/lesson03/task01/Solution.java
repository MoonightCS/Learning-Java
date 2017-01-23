package com.javarush.test.level18.lesson03.task01;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int max = Integer.MIN_VALUE;
        int n;
        while (inputStream.available() > 0) {
            n = inputStream.read();
            if (n > max) {
                max = n;
            }
        }
        reader.close();
        inputStream.close();
        System.out.println(max);
    }
}
