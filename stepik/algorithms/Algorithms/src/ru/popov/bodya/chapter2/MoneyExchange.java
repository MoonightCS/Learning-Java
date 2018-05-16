package ru.popov.bodya.chapter2;

import java.util.Scanner;

public class MoneyExchange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        final int[] types = new int[]{25, 10, 5, 1};
        final int[] result = new int[4];

        int i = 0;
        for (int type : types) {
            final int value = n / type;
            result[i++] = value;
            n -= value * type;
        }

        for (int j = 3; j >= 1; j--) {
            final int valueToTransfer = result[j] / types[j - 1];
            result[j - 1] += valueToTransfer;
            result[j] -= (valueToTransfer * types[j - 1]);
        }


        for (int j = 0; j < result.length; j++) {
            System.out.println("type: " + types[j] + "; count: " + result[j]);
        }

    }


}
