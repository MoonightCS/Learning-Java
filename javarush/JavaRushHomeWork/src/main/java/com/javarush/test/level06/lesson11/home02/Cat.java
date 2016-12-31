package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;
import java.util.List;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat {
    public static ArrayList<Cat> cats;
    private final String name;

    public Cat(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        cats = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cats.add(new Cat("cat" + i));
        }
        printCats();
    }

    public static void printCats() {
        int length = cats.size();
        for (int i = 0; i < length; i++) {
            System.out.println(cats.get(i));
        }
    }
}
