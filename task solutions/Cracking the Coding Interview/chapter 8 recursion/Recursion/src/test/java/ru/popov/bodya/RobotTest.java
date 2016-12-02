package ru.popov.bodya;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {
    Robot robot;

    @Before
    public void init() {
        robot = new Robot();
    }

    @Test
    public void checkFieldNxN() {
        for (int i = 1; i < 10; i++) {
            checkField(i);
        }
    }

    private void checkField(int fieldSize){
        int n = 2 * fieldSize - 2;
        int k = fieldSize - 1;
        Assert.assertEquals(Binom.recBinomial(n,k),robot.robotControl(fieldSize));
    }


}