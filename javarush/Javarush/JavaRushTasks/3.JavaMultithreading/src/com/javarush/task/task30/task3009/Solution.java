package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* 
Объяви и реализуй логику приватного статического метода Set<Integer> getRadix(String number), в котором нужно определить, в каких системах счисления (от 2 до 36 включительно)
представление числа number (передается в десятичной системе счисления) является палиндромом и добавить индекс таких систем в результат.
Если переданное число некорректно — возвращай пустой HashSet.
В системах счисления с основанием большим 10 в качестве цифр используются латинские буквы. К примеру, числу 35 в десятичной системе соответствует число «Z» в системе с основанием 36.

Метод main не принимает участие в тестировании.

P.S.: В методе getRadix перехватывай NumberFormatException. Стек-трейс выводить не нужно.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> set = new HashSet<>();
        try {
            int x = Integer.parseInt(number);
            for (int i = 2; i <= 36; i++) {
                String s = Integer.toString(x, i);
                if (isPalindrome(s)) {
                    set.add(i);
                }
            }
        } catch (NumberFormatException e) {
        }

        return set;
    }


    private static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n / 2); i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
}