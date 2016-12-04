package ru.popov.bodya.humancollection;

public class Man implements Human {
    private final String name;

    public Man(String name) {
        this.name = name;
    }

    @Override
    public Sex getSex() {
        return Sex.M;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
