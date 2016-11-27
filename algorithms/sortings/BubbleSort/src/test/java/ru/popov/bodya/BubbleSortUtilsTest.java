package ru.popov.bodya;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BubbleSortUtilsTest {

    private int[] array;
    private final static int ARRAY_SIZE = 30;
    private final static int MAX_VALUE = 100;

    @Before
    public void initArray() {
        array = new int[ARRAY_SIZE];
        Random ran = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = ran.nextInt(MAX_VALUE);
        }
    }

    @Test
    public void testMergeSort() {
        BubbleSortUtils.bubbleSort(array);
        printArray();
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                fail("array is not sorted");
            }
        }
        assertTrue(true);
    }

    @Test
    public void multiTest() {
        for (int i = 0; i < 10; i++) {
            initArray();
            BubbleSortUtils.bubbleSort(array);
            testMergeSort();
        }
    }

    private void printArray() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}