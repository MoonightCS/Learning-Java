package ru.popov.bodya.constructor;

public class User {

    private final String name;

    public User(String name, int number) {
        this.name = name;

    }
    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
