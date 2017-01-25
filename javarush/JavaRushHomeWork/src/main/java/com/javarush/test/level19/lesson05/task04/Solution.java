package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader startReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = startReader.readLine();
        String fileName2 = startReader.readLine();
        startReader.close();

        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);

        while (fileReader.ready()) {
            int data = fileReader.read();
            data = data == 46 ? 33 : data;
            fileWriter.write(data);
        }
        fileReader.close();
        fileWriter.close();
    }
}
