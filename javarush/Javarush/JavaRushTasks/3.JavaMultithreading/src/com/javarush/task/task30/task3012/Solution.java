package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.*;

public class Solution {

    List<Integer> expression = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 9, 27, 81, 243, 729, 2187));
        findExpression(number, 0, 0, numbers, new Stack<>());
        Collections.reverse(expression);
        System.out.print(number + " =");
        for (int i = 0; i < expression.size(); i++) {
            int n = expression.get(i);
            if (n < 0) {
                System.out.printf(" - %d", Math.abs(n));
            } else System.out.printf(" + %d", n);
        }

    }

    private boolean findExpression(int number, int ourNumber, int index, List<Integer> numbers, Stack<Integer> stack) {
        if (number == ourNumber) {
            while (!stack.isEmpty()) {
                expression.add(stack.pop());
            }
            return true;
        }
        if (numbers.size() == index) {
            return false;
        }

        int integer = numbers.get(index);
        stack.push(integer);
        if (findExpression(number, ourNumber + integer, index + 1, numbers, stack)) {
            return true;
        }
        stack.pop();
        integer = -integer;
        stack.push(integer);

        if (findExpression(number, ourNumber + integer, index + 1, numbers, stack)) {
            return true;
        }
        stack.pop();

        if (findExpression(number, ourNumber, index + 1, numbers, stack)) {
            return true;
        } else {
            return false;
        }
    }
}