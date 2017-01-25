package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
        String line;
        int result = 0;
        while ((line = reader1.readLine()) != null) {
            result += workWithLine(line);
        }
        reader1.close();
        System.out.println(result);
    }

    private static int workWithLine(String line) {
        int worldCount = 0;
        String[] words = line.split("\\W");
        for (String str : words) {
            if (str.equals("world")) {
                ++worldCount;
            }
        }
        return worldCount;
    }
}
