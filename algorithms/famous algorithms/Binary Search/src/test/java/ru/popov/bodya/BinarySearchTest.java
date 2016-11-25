package ru.popov.bodya;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchTest {

    private int[] array;
    private final static int ARRAY_SIZE = 30;
    private final static int MAX_VALUE = 100;

    @Before
    public void initArray() {
        array = new int[ARRAY_SIZE];
        Random ran = new Random(29);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = ran.nextInt(MAX_VALUE);
        }
        Arrays.sort(array);
    }

    @Test
    public void binarySearchWithExpectedValue() {
        Assert.assertEquals(true, BinarySearch.binarySearchBoolean(array, 51));
    }

    @Test
    public void binarySearchWithUnexpectedValue() {
        Assert.assertEquals(false, BinarySearch.binarySearchBoolean(array, 46));
    }


    @Test
    public void binarySearchToFindIndexOfNumber() {
        Assert.assertEquals(14, BinarySearch.binarySearchInt(array, 51));
    }

    private void printArray() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}