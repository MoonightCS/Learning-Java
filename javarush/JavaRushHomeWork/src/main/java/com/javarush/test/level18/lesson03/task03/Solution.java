package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> countsOfBytes = new HashMap<>();
        int n;
        int maxCount = 0;
        if (inputStream.available() > 0) {
            maxCount = 1;
        }
        while (inputStream.available() > 0) {
            n = inputStream.read();
            if (countsOfBytes.containsKey(n)) {
                int newValue = countsOfBytes.get(n) + 1;
                countsOfBytes.put(n, newValue);
                if (newValue > maxCount) {
                    maxCount = newValue;
                }
            } else {
                countsOfBytes.put(n, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : countsOfBytes.entrySet()) {
            if (entry.getValue() == maxCount) {
                System.out.println(entry.getKey());
            }
        }
        reader.close();
        inputStream.close();

    }
}
