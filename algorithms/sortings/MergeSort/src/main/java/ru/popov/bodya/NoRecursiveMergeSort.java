package ru.popov.bodya;

import java.util.Arrays;

public class NoRecursiveMergeSort {

    public static void sortMergeNoRecursive(int[] arr) {
        int len = arr.length;
        int n = 1;
        int shift;
        int two_size;

        while (n < len) {
            shift = 0;
            while (shift < len) {
                if (shift + n >= len) break;
                two_size = (shift + n * 2 > len) ? (len - (shift + n)) : n;
                merge(arr, shift, shift + n, shift + n + two_size );
                shift += n * 2;
            }
            n *= 2;
        }
    }

    public static void merge(int[] arr, int first, int middle, int last) {

        int[] tmpArray = Arrays.copyOfRange(arr, first, middle);

        int len = tmpArray.length;
        int i = 0;
        int j = middle;
        int k = first;

        while (i < len && j < last) {
            if (tmpArray[i] <= arr[j]) {
                arr[k] = tmpArray[i];
                i++;
            } else {
                arr[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < len) {
            arr[k] = tmpArray[i];
            k++;
            i++;
        }
    }
}
