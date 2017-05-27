package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией — выведи «[полный путь] — не папка» и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок — [количество папок в директории]
Всего файлов — [количество файлов в директории и поддиректориях]
Общий размер — [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.
*/
public class Solution {

    private static long sizeOfDirectory;
    private static long foldersCounter = 0;
    private static int filesCounter = 0;

    public static void main(String[] args) throws IOException {

        Path folderPath;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            folderPath = Paths.get(reader.readLine().trim());
        }

        if (!Files.isDirectory(folderPath)) {
            System.out.println(folderPath.toString() + " - не папка");
            return;
        }

        MyFileVisitor myFileVisitor = new MyFileVisitor();
        Files.walkFileTree(folderPath, myFileVisitor);
        System.out.println("Всего папок - " + (foldersCounter - 1));
        System.out.println("Всего файлов - " + filesCounter);
        System.out.println("Общий размер - " + sizeOfDirectory);
    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            filesCounter++;
            sizeOfDirectory += attrs.size();
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs) {
            foldersCounter++;
            return FileVisitResult.CONTINUE;
        }
    }

}

