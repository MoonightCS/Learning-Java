package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(fileName1);
        FileInputStream inputStream2 = new FileInputStream(fileName2);
        int avail1 = inputStream1.available();
        int avail2 = inputStream2.available();

        byte[] bytes = new byte[avail1 + avail2];
        inputStream2.read(bytes, 0, avail2);
        inputStream1.read(bytes, avail2, avail1);

        inputStream1.close();
        inputStream2.close();
        reader.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }
}
