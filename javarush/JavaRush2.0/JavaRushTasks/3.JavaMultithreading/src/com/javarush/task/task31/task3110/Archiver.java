package com.javarush.task.task31.task3110;

/*
5. Реализуй метод execute() в классе ExitCommand, он должен выводить “До встречи!” с помощью
метода из класса ConsoleHelper
6. В самом конце метода main в класса Archiver добавь код, который создает объект типа ExitCommand и вызывает у него метод execute()
7. Попробуй, как это все работает
Обрати внимание, что все файлы проекта должны быть в кодировке UTF-8. Кодировку в IntelliJ IDEA можно задать через пункты меню Settings -> Editor -> File Encodings.
Проверь, что все три поля отвечающие за кодировку выставлены в UTF-8.
 */

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь до архива");
        String fileName = reader.readLine();
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(fileName));
        System.out.println("Введите полный путь до файла для архивации");
        zipFileManager.createZip(Paths.get(reader.readLine()));

        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}
