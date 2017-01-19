package com.javarush.test.level13.lesson11.bonus03;

public class Robot extends AbstractRobot {
    private static int hitCount;
    private String name;

    public String getName() {
        return name;
    }

    public Robot(String name) {
        this.name = name;
    }
}
