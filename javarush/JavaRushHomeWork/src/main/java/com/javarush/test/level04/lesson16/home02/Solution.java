package com.javarush.test.level04.lesson16.home02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine().trim());
        int number2 = Integer.parseInt(reader.readLine().trim());
        int number3 = Integer.parseInt(reader.readLine().trim());
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(number1);
        treeSet.add(number2);
        treeSet.add(number3);
        treeSet.pollFirst();
        System.out.println(treeSet.pollFirst());
    }
}
