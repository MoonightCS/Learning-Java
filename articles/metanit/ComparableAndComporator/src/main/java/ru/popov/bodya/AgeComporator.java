package ru.popov.bodya;

import java.util.Comparator;

public class AgeComporator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() > o2.getAge() ? 1 : o1.getAge() < o1.getAge() ? -1 : 0;
    }
}
