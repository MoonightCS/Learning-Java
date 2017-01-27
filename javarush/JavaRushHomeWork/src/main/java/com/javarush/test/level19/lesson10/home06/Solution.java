package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<>();
    private static List<String> numbers = new ArrayList<>(Arrays.asList("ноль", "один", "два", "три", "четыре", "пять",
            "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать"));

    static {
        for (int i = 0; i < 13; i++) {
            map.put(i, numbers.get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        final String fileName = fileNameReader.readLine();
        fileNameReader.close();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(workWithLine(line));
        }
        reader.close();
    }

    private static String workWithLine(final String line) {
        StringBuilder sb = new StringBuilder();
        String[] data = line.split(" ");
        for (String s : data) {
            try {
                int number = Integer.parseInt(s);
                if (number >= 0 && number <= 12) {
                    sb.append(map.get(number));
                } else {
                    sb.append(number);
                }
            } catch (NumberFormatException e) {
                sb.append(s);
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
