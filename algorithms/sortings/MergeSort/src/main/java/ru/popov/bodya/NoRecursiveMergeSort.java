package ru.popov.bodya;

import java.util.Arrays;

public class NoRecursiveMergeSort {

    public static void sortMergeNoRecursive(int[] arr) {
        int len = arr.length;
        int step = 1;
        int shift;
        int secondArrSize;

        while (step < len) {
            shift = 0;
            while (shift < len) {
                if (shift + step >= len)
                    break;
                secondArrSize = (shift + 2 * step > len) ? (len - (shift + step)) : step;
                merge(arr, shift, shift + step, shift + step + secondArrSize );
                shift += step * 2;
            }
            step *= 2;
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
