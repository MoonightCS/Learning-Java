package ru.popov.bodya;

import java.util.Arrays;
import java.util.Random;

public class RecursiveMergeSort {

    public static void mergeSort(int[] arr, int first, int last) {

        if (first < last) {

//          int middle = first + (last - first) / 2;
            int middle = (int)Math.random()* (last - first) + first;

            mergeSort(arr, first, middle);
            mergeSort(arr, middle + 1, last);
            merge(arr, first, middle, last);
        }
    }

    public static void merge(int[] arr, int first, int middle, int last) {

        int[] tmpArray = Arrays.copyOfRange(arr, first, middle + 1);

        int len = tmpArray.length;
        int i = 0;
        int j = middle + 1;
        int k = first;

        while (i < len && j <= last) {
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
