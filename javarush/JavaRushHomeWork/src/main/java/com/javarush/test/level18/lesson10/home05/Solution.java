package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/
// 3 4 4 -3 -3 -4
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream = new FileOutputStream(fileName2);

        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        outputStream.write(getNumbers(bytes));

        reader.close();
        inputStream.close();
        outputStream.close();

    }

    private static byte[] getNumbers(byte[] bytes) {

        StringBuilder builder = new StringBuilder();
        String[] s = (new String(bytes)).split(" ");

        for (String value : s) {
            builder.append(Math.round(Double.valueOf(value)));
            builder.append(" ");
        }
        return builder.toString().getBytes();
    }
}
