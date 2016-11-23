package ru.popov.bodya.java8tutorial.defaultmethods;

public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}
