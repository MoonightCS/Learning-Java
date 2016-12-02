package ru.popov.bodya;

public class Binom {

    public static long recBinomial(int n, int k) {
        if ((n == k) || (k == 0))
            return 1;
        else
            return recBinomial(n - 1, k) + recBinomial(n - 1, k - 1);
    }

    public static long nonRecBinomial(int n, int k) {
        if (k > n - k)
            k = n - k;

        long b = 1;
        for (int i = 1, m = n; i <= k; i++, m--)
            b = b * m / i;
        return b;
    }

    public static void main(String[] args) {
        System.out.println(nonRecBinomial(4,2));
        System.out.println(recBinomial(6,3));
    }
}
