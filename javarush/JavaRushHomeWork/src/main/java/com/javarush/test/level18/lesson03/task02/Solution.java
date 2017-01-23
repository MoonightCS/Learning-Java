package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int min = Integer.MAX_VALUE;
        int n;
        while (inputStream.available() > 0) {
            n = inputStream.read();
            if (n < min) {
                min = n;
            }
        }
        reader.close();
        inputStream.close();
        System.out.println(min);
    }
}
