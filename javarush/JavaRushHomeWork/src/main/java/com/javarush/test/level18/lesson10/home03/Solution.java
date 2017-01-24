package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream is1 = new FileInputStream(fileName2);
        FileInputStream is2 = new FileInputStream(fileName3);
        FileOutputStream outputStream = new FileOutputStream(fileName1);

        readAndWrite(is1, outputStream);
        readAndWrite(is2, outputStream);

        is1.close();
        is2.close();
        outputStream.close();
        reader.close();
    }

    private static void readAndWrite(FileInputStream inputStream, FileOutputStream outputStream) throws IOException {
        while (inputStream.available() > 0) {
            outputStream.write(inputStream.read());
        }
    }
}
