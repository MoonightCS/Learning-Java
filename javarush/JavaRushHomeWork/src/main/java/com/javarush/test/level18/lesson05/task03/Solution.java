package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName3);

        int avail = inputStream.available();
        if (avail > 0) {
            byte[] firstHalf = new byte[avail - avail / 2];
            byte[] secondHalf = new byte[avail / 2];

            int count = inputStream.read(firstHalf);
            fileOutputStream1.write(firstHalf, 0, count);

            count = inputStream.read(secondHalf);
            fileOutputStream2.write(secondHalf, 0, count);
        }
        inputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
        reader.close();
    }
}
