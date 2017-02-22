package com.javarush.task.task29.task2909.human;

/*
Задания:
1.1. Подъем поля. Подними поле children в базовый класс.
1.2. Подъем метода. Подними сеттер и геттер для children в базовый класс.
1.3. Инкапсуляция коллекции.
1.3.1. Метод getChildren должен возвращать не модифицируемое представление списка children.
1.3.2. Убери сеттер для children.
1.3.3. Добавь методы addChild(Human) и removeChild(Human). Реализуй их логику.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {

    public static int nextId = 0;
    private int id;
    private List<Human> children = new ArrayList<>();
    protected int age;
    protected String name;

    protected int[] size;


    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    private int bloodGroup;

    public void addChild(Human human) {
        children.add(human);
    }

    public void removeChild(Human human) {
        children.remove(human);
    }

    public void setBloodGroup(int code) {
        bloodGroup = code;
    }

    public int getBloodGroup() {
        return bloodGroup;
    }


    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public void live() {

    }

    public void printSize() {
        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }
}