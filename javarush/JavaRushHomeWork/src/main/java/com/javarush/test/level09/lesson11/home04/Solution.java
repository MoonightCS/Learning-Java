package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Solution {

    /*Ввести с клавиатуры дату в формате «08/18/2013»
    Вывести на экран эту дату в виде «AUG 18, 2013».
    Воспользоваться объектом Date и SimpleDateFormat.
    */

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = reader.readLine().split("/");

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Integer.parseInt(values[0]) - 1);
        cal.set(Calendar.DATE, Integer.parseInt(values[1]));
        cal.set(Calendar.YEAR, Integer.parseInt(values[2]));
        Date date = cal.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(simpleDateFormat.format(date).toUpperCase());

    }
}
