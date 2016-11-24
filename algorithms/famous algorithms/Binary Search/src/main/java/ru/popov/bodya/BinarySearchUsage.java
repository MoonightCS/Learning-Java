package ru.popov.bodya;

public class BinarySearchUsage {

    public static int calculateCountOfNumberInArray(int[] array, int number) {
        return binarySearchInt(array, number+1) - binarySearchInt(array, number);
    }

    private static int binarySearchInt(int[] arr, int key) {
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
