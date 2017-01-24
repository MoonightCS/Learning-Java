package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileInputStream inputStream = new FileInputStream(fileName);
        int count = 0;
        while (inputStream.available() > 0) {
            int tmp = inputStream.read();
            if ((tmp >= 65 && tmp <= 90) || (tmp >= 97 && tmp <= 122)) {
                count++;
            }
        }
        inputStream.close();
        System.out.println(count);
    }
}
