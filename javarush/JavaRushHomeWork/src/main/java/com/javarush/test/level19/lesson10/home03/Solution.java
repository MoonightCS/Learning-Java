package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String input;
        while ((input = fileReader.readLine()) != null) {
            workWithLine(input);
        }
        fileReader.close();

    }

    private static void workWithLine(String line) {
        String[] data = line.split(" ");
        String name = "";
        for (int i = 0; i < data.length - 3; i++) {
            if (i == data.length - 4)
                name = name + data[i];
            else
                name = name + data[i] + " ";
        }

        Date date = new GregorianCalendar(
                Integer.parseInt(data[data.length - 1]),
                Integer.parseInt(data[data.length - 2]) - 1,
                Integer.parseInt(data[data.length - 3]))
                .getTime();

        PEOPLE.add(new Person(name, date));
    }
}
