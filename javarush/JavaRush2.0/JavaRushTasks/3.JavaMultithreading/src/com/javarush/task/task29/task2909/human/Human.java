package com.javarush.task.task29.task2909.human;

/*
Рефакторинг (5)
5.1. Создание шаблонного метода.
5.1.1. Добавь в класс Human метод String getPosition(), который должен возвращать строку «Человек«.
5.1.2. Переопредели этот метод в классе Student и Teacher. Метод должен возвращать «Студент» и «Преподаватель» соответственно.
5.1.3. Замени метод printData в подклассах шаблонным методом в базовом классе, использующим getPosition().
5.2. Замена делегирования наследованием. Класс Worker должен наследоваться от Human, а не содержать его.
5.3. Переименование метода. Переименуй метод setSlr, чтобы было понятно сеттером чего является этот метод.


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

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public String getPosition() {
        return "Человек";
    }

    @Override
    public void live() {

    }

    public void printSize() {
        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }
}