package com.javarush.test.level03.lesson08.task05;

/* Чистая любовь
Ввести с клавиатуры три имени, вывести на экран надпись:
name1 + name2 + name3 = Чистая любовь, да-да!
Пример: Вася + Ева + Анжелика = Чистая любовь, да-да!
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String name1 = reader.readLine().trim();
        final String name2 = reader.readLine().trim();
        final String name3 = reader.readLine().trim();
        System.out.printf("%s + %s + %s = Чистая любовь, да-да!", name1, name2, name3);

    }
}