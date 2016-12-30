package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat {

    private static int AVERAGE_AGE = 5;
    private static int AVERAGE_WEIGHT = 4;
    private String name;
    private int weight;
    private int age;
    private String color;
    private String address;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.weight = AVERAGE_WEIGHT;
        this.age = age;
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.age = AVERAGE_AGE;
        this.color = color;
        this.name = null;
        this.color = null;
    }

    public Cat(int weight, String color, String address) {
        this.name = null;
        this.weight = weight;
        this.age = AVERAGE_AGE;
        this.color = color;
        this.address = address;
    }
}
