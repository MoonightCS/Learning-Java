package ru.popov.bodya;

/**
 * Find all string combinations consisting only of 0, 1 and ?
 */
public class QueCombinations {

    private char[] string = new char[]{'1', '?', '1', '?', '0'};
    private char[] answer = new char[string.length];

    public static void main(String[] args) {
        QueCombinations queCombinations = new QueCombinations();
        queCombinations.combinations(0, queCombinations.string, queCombinations.string.length);
    }

    public void combinations(int i, char[] str, int size) {
        if (i == size - 1) {
            if (str[i] == '?') {
                answer[i] = '0';
                System.out.println(answer);
                answer[i] = '1';
                System.out.println(answer);
            }
            answer[i] = str[i];
            System.out.println(answer);
            return;
        }
        if (str[i] == '?') {
            answer[i] = '0';
            combinations(i + 1, str, size);
            answer[i] = '1';
            combinations(i + 1, str, size);
        } else {
            answer[i] = str[i];
            combinations(i + 1, str, size);
        }
    }
}
