package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> data = new TreeMap<>();
        String line;
        String[] lineParams;
        while ((line = reader.readLine()) != null) {
            lineParams = line.split(" ");
            if (data.containsKey(lineParams[0])) {
                Double value = data.get(lineParams[0]);
                data.put(lineParams[0], Double.parseDouble(lineParams[1])+ value);
            } else {
                data.put(lineParams[0], Double.parseDouble(lineParams[1]));
            }
        }
        reader.close();
        for (String key : data.keySet()) {
            System.out.println(key + " " + data.get(key));
        }
    }
}
