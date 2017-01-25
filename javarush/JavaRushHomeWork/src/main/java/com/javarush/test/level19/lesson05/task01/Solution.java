package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        int count = 0;
        while (inputStream.available() > 0) {
            ++count;
            if (count % 2 == 0) {
                fileOutputStream.write(inputStream.read());
            } else {
                inputStream.read();
            }
        }
        inputStream.close();
        fileOutputStream.close();
    }
}
