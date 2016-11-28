package ru.popov.bodya;

import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Set<Person> treeSet = new TreeSet<>(new AgeComporator().thenComparing(new NameComporator()));
        treeSet.add(new Person("Bodya"));
        treeSet.add(new Person("Maryana", 20));
        treeSet.add(new Person("Dima"));
        treeSet.add(new Person("Alex", 30));
        treeSet.add(new Person("Bob",22));

        treeSet.forEach(System.out::println);
        System.out.println("________________");
        treeSet.stream()
                .filter((s) -> s.getName().startsWith("B"))
                .forEach(System.out::println);
    }
}
