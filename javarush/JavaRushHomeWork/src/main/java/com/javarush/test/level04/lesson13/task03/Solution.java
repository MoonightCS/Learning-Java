package com.javarush.test.level04.lesson13.task03;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int count = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count; j++) {
                System.out.print(8);
            }
            count++;
            System.out.println();
        }

    }
}
