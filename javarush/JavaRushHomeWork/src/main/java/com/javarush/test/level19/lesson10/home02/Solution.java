package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> data = new HashMap<>();
        String line;
        String[] lineParams;
        double max = Double.MIN_VALUE;
        while ((line = reader.readLine()) != null) {
            lineParams = line.split(" ");
            if (data.containsKey(lineParams[0])) {
                Double value = data.get(lineParams[0]);
                data.put(lineParams[0], Double.parseDouble(lineParams[1]) + value);
            } else {
                data.put(lineParams[0], Double.parseDouble(lineParams[1]));
            }
            double value = data.get(lineParams[0]);
            if (max < value) {
                max = value;
            }
        }
        reader.close();
        for (Map.Entry<String, Double> entry: data.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey());
            }
        }
    }
}
