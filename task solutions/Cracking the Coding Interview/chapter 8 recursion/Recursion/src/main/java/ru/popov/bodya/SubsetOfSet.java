package ru.popov.bodya;

/**
 * Write a method that returns all subsets of a set.
 */

public class SubsetOfSet {

    private int[] binAnswer = new int[]{0, 0, 0};
    private int[] set = new int[]{1, 2, 3};
    private int SIZE = set.length;

    private void print() {

        int flag = 0;

        for (int i = 0; i < SIZE; i++) {
            if (binAnswer[i] == 1) {
                System.out.print(set[i]);
                flag = 1;
            }
        }
        if (flag == 1)
            System.out.print("\n");
        else
            System.out.print("~ \n");

    }

    public void comb(int x) {

        if (x == SIZE - 1) {
            binAnswer[x] = 0;
            print();
            binAnswer[x] = 1;
            print();
            return;
        }
        binAnswer[x] = 0;
        comb(x + 1);
        binAnswer[x] = 1;
        comb(x + 1);

    }
}
