package com.javarush.task.task29.task2909.car;

public class Cabriolet extends Car {

    private final static int MAX_SPEED = 90;

    public Cabriolet(int numberOfPassengers) {
        super(Car.CABRIOLET, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SPEED;
    }
}
