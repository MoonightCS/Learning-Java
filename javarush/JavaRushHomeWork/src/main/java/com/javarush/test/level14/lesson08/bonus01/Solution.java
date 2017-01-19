package com.javarush.test.level14.lesson08.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String nullPoint = null;
            nullPoint.charAt(3);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] a = new int[-1];
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] a = new int[3];
            a[3] = 2;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 3, 2));
            arrayList.get(3);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Object x = 0;
            System.out.println((String) x);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object szStr[] = new String[1];
            szStr[0] = '5';
        } catch (Exception e) {
            exceptions.add(e);
        }


        try {
            String szShortString = "123";
            szShortString.charAt(10);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int i = Integer.parseInt("yo");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            throw new IOException();
        } catch (IOException e) {
            exceptions.add(e);
        }

    }
}
