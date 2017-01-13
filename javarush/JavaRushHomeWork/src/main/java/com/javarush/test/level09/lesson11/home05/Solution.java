package com.javarush.test.level09.lesson11.home05;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] array = reader.readLine().trim().toCharArray();
        char[] vowels = new char[array.length];
        char[] others = new char[array.length];
        int i = 0, j = 0;
        for (char c : array) {
            if (isVowel(c)) {
                vowels[i] = c;
                i++;
            } else if (c != ' ') {
                others[j] = c;
                j++;
            }

        }
        printArray(vowels, i);
        printArray(others, j);

    }

    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);

        for (char d : vowels) {
            if (c == d)
                return true;
        }
        return false;
    }

    private static void printArray(char[] array, int size) {
        for (int k = 0; k < size; k++) {
            System.out.printf("%c ", array[k]);
        }
        System.out.println();
    }
}
