package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> countOfChars = new TreeMap<>();
        FileInputStream inputStream = new FileInputStream(args[0]);

        while (inputStream.available() > 0) {
            int tmp = inputStream.read();
            int result = countOfChars.getOrDefault(tmp, 0);  //since 1.8 ;(
            if (result != 0) {
                countOfChars.put(tmp, result + 1);
            } else {
                countOfChars.put(tmp, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : countOfChars.entrySet()) {
            int tmp = entry.getKey();
            System.out.println((char) tmp + " " + entry.getValue());
        }
        inputStream.close();
    }
}
