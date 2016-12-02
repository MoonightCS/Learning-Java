package ru.popov.bodya;

public class BinarySearch {

    public static boolean binarySearchBoolean(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (right >= left) {
            int middle = left + (right - left) / 2;
            if (arr[middle] == key) {
                return true;
            }
            if (arr[middle] < key) {
                left = middle + 1;
            }
            if (arr[middle] > key) {
                right = middle - 1;
            }
        }
        return false;
    }

    public static int binarySearchInt(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (arr[middle] >= key)
                right = middle;
            else
                left = middle;

        }
        return right;
    }
}
