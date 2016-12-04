package ru.popov.bodya.humancollection;

public class Woman implements Human{

    private final String name;

    public Woman(String name) {
        this.name = name;
    }

    @Override
    public Sex getSex() {
        return Sex.F;
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
