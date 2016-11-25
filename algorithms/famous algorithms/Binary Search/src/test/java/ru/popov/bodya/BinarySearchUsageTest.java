package ru.popov.bodya;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class BinarySearchUsageTest {

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
    public void binarySearchToCalculateCountOfNumber() {
        Assert.assertEquals(2, BinarySearchUsage.calculateCountOfNumberInArray(array, 51));
    }

    private void printArray() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}