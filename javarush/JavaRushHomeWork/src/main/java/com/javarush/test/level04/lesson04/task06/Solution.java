package com.javarush.test.level04.lesson04.task06;

/* День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше или меньше 7 – вывести «такого дня недели не существует».
Пример для номера 5:
пятница
Пример для номера 10:
такого дня недели не существует
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static String[] DAYS = new String[]{"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.parseInt(reader.readLine().trim());
        if (day > 7 || day < 1) System.out.println("такого дня недели не существует");
        else System.out.println(DAYS[day - 1]);
    }

}