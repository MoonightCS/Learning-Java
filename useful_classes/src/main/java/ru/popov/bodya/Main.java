package ru.popov.bodya;

import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.add(1);
        list.forEach(System.out::println);

    }
}
