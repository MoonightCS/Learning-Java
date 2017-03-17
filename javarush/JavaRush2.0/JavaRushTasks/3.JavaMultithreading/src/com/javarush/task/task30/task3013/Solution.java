package com.javarush.task.task30.task3013;

/* 
Используй только операции:
1) =
2) |
3) &
4) >>
5) <<
6) ~
7) цифры от 0 до 9 включительно
8) круглые скобки
9) оператор "return" для возврата результата метода.

ЗАПРЕЩЕНО создавать переменные, использовать циклы, условные операторы и прочее.

Имя параметра метода resetLowerBits не изменяй (должно быть "number").

Метод main не принимает участия в тестировании.
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        number |= (number >> 1);
        number |= (number >> 2);
        number |= (number >> 4);
        number |= (number >> 8);
        number |= (number >> 16);
        return(number & ~(number >> 1));
    }
}