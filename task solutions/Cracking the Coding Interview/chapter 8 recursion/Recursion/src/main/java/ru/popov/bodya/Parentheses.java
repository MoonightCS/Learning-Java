package ru.popov.bodya;

/**
 * Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n-pairs of parentheses.
 */

public class Parentheses {

    public void findParentheses(int n) {
        parentheses(n, 0, "");
    }

    private void parentheses(int open, int closed, String result) {

        if (open == 0 && closed == 0) {
            System.out.println(result);
        }
        if (open > 0) {
            parentheses(open - 1, closed + 1, result + "(");
        }
        if (closed > 0) {
            parentheses(open, closed - 1, result + ")");
        }
    }

    public static void main(String[] args) {

        Parentheses parentheses = new Parentheses();
        parentheses.findParentheses(3);
    }

}
