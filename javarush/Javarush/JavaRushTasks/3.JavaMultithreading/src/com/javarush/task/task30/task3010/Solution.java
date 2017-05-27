package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        int min = 2;
        String string = args[0];

        for (char ch : string.toUpperCase().toCharArray()) {
            int intC = (int) ch;
            if (isInNumberRange(intC)) {
                int tmp = intC - 48;
                if (tmp > min) {
                    min = tmp;
                }
            } else if (isInLetterRange(intC)) {
                int tmp = intC - 54;
                if (min < tmp) {
                    min = tmp;
                }
            } else {
                System.out.println("incorrect");
                return;
            }
        }
        System.out.println(min);
    }

    private static boolean isInNumberRange(int ch) {
        return ch >= 48 && ch <= 57;
    }

    private static boolean isInLetterRange(int ch) {
        return ch >= 65 && ch <= 90;
    }
}