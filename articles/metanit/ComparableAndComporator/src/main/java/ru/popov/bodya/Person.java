package ru.popov.bodya;

public class Person implements Comparable<Person> {


    private final String name;
    private int age;

    public Person(String name) {
        this(name, 21);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return getName() + " with age: " + getAge();
    }
}
