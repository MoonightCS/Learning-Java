package ru.popov.bodya;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = tryToRead(reader);
        String destinationFileName = reader.readLine();


        FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    private static FileInputStream tryToRead(BufferedReader reader) throws IOException {
        while (true) {
            try {
                String sourceFileName = reader.readLine();
                return new FileInputStream(sourceFileName);
            } catch (FileNotFoundException e) {
                System.out.println("Файл не существует.");

            }
        }

    }
}
