package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog {
    private String name;
    private int weight;
    private String color;

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Dog(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }
}
