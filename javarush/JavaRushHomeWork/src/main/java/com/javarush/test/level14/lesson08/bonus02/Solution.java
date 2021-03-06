package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine().trim());
        int b = Integer.parseInt(reader.readLine().trim());
        System.out.println(gcd(a, b));
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else return gcd(b, a % b);
    }
}
