package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    static int size(long x) {
        long p = 10;
        for (int i = 1; i < 19; i++) {
            if (x < p)
                return i;
            p = 10 * p;
        }
        return 19;
    }

    public static int[] getNumbers(int N) {
        List<Integer> list = new ArrayList<>();


        for (int i = 1; i < N; i++) {
            long sum = 0;
            int k = i;
            int m = size(i);
            for (int j = 0; j < m; j++) {
                int value = 1;
                int base = k % 10;
                for (int z = 0; z < m; z++) {
                    value = value * base;
                }
                sum += value;
                k = k / 10;
            }

            if (i == sum) {
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String args[]) {

        CountDown countDown = new CountDown();
        countDown.start();
        int[] result = getNumbers(2147483647);
        countDown.interrupt();
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static class CountDown extends Thread {
        @Override
        public void run() {
            int sec = 0;
            while (!isInterrupted()) {
                System.out.printf("All time passsed: %d seconds\n", sec);
                sec++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("All done!");
                    return;
                }
            }


        }
    }
}
