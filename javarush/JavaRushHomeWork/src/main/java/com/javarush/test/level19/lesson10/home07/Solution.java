package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(" ");
            for (String word : data) {
                if (checkWord(word)) {
                    sb.append(word).append(",");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        writer.write(sb.toString());

        reader.close();
        writer.close();
    }

    private static boolean checkWord(final String line) {
        return line.length() > 6;
    }
}
