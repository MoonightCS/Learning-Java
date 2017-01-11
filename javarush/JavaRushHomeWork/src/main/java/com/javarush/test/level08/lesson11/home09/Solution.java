package com.javarush.test.level08.lesson11.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution {
    public static void main(String[] args) {

        String dateStr = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            dateStr = reader.readLine().trim();
        } catch (IOException io) {
            System.out.println("IO exception with reading date");
        }


        System.out.println(dateStr + " = " + isDateOdd(dateStr));
    }

    public static boolean isDateOdd(String date) {

        Date currentTime = new Date(date);
        Date newYearTime = new Date(date);
        newYearTime.setMonth(0);
        newYearTime.setHours(0);
        newYearTime.setDate(1);
        newYearTime.setSeconds(0);
        newYearTime.setMinutes(0);

        long msTimeDistance = currentTime.getTime() - newYearTime.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках
        int dayCount = (int) (msTimeDistance / msDay); //количество целых дней

        return dayCount % 2 == 0;
    }
}
