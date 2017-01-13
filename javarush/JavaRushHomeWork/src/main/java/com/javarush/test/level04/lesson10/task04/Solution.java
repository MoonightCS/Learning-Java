package com.javarush.test.level04.lesson10.task04;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int x = 10;
        while (x > 0) {
            int y = 10;
            while (y > 0) {
                System.out.print("S");
                y--;
            }
            System.out.println();
            x--;
        }

    }
}
