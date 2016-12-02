package ru.popov.bodya;

/**
 * Imagine a robot sitting on the upper left hand corner of an NxN grid.
 * The robot can only move in two directions: right and down.
 * How many possible paths are there for the robot to get bottom right hand corner?
 */

public class Robot {

    public int robotControl(int size) {
        return robotMove(size - 1, size - 1);
    }

    private int robotMove(int right, int down) {

        int a = 0, b = 0;

        if (right == 0 && down == 0) {
            return 1;
        }

        if (right != 0) {
            a = robotMove(right - 1, down);
        }

        if (down != 0) {
            b = robotMove(right, down - 1);
        }

        return a + b;
    }

}
