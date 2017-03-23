package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент — полный путь к файлу fileName.
Второй аргумент — путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию ‘new‘.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
 String fileName = "/Users/bogdanpopov/Desktop/testArchive/test.mp3";
 String zipPath = "/Users/bogdanpopov/Desktop/testArchive/archive.zip";
*/


public class Solution {
    public static Map<ZipEntry, byte[]> entryMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        File zipArchive = new File(args[1]);
        File addedFile = new File(args[0]);

        collectAllEntries(zipArchive);
        addNewFile(addedFile, zipArchive);
    }


    public static void collectAllEntries(File file) {

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int size;
                while ((size = zipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, size);
                }
                byte[] bytes = byteArrayOutputStream.toByteArray();
                entryMap.put(zipEntry, bytes);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void addNewFile(File addedFile, File zipArchive) {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipArchive)); FileInputStream fileInputStream = new FileInputStream(addedFile)) {


            ZipEntry fileNameComparator = new ZipEntry(addedFile.getName());

            for (Map.Entry<ZipEntry, byte[]> zipEntry : entryMap.entrySet()) {

                Path path = Paths.get(zipEntry.getKey().getName());

                if (!(path.getFileName().toString().equals(fileNameComparator.getName()))) {

                    zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getKey().getName()));
                    zipOutputStream.write(zipEntry.getValue());
                    zipOutputStream.closeEntry();

                }
            }

            ZipEntry addingFileEntry = new ZipEntry("archive/new/" + addedFile.getName());
            zipOutputStream.putNextEntry(addingFileEntry);

            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            zipOutputStream.write(buffer);
            zipOutputStream.closeEntry();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
