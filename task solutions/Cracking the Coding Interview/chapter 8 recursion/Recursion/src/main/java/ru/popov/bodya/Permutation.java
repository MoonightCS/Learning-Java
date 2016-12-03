package ru.popov.bodya;

/**
 * Write a method to compute all permutations of a string.
 */

public class Permutation {

    public void findPermutation(String string) {
        permutation("", string);
    }

    private void permutation(String prefix, String string) {
        int len = string.length();
        if (len == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < len; i++) {
                permutation(prefix + string.charAt(i), string.substring(0,i) + string.substring(i + 1,len));
            }
        }
    }
}
