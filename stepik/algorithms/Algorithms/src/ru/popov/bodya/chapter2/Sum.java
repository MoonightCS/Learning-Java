package ru.popov.bodya.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        final List<Integer> result = new ArrayList<>();

        int currentNumber = 1;
        while (n > 2 * currentNumber) {
            n -= currentNumber;
            result.add(currentNumber);
            currentNumber++;
        }
        result.add(n);

        System.out.println(result.size());
        result.forEach(integer -> System.out.print(integer + " "));
    }
}
