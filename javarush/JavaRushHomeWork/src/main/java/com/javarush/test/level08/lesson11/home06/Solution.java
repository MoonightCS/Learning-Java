package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Human> family = new ArrayList<>();
        Human child1 = new Human("Child1", true, 5, null);
        Human child2 = new Human("Child2", false, 10, null);
        Human child3 = new Human("Child3", true, 15, null);
        ArrayList<Human> childes = new ArrayList<>(Arrays.asList(child1, child2, child3));
        Human mother = new Human("Mother", false, 40, childes);
        Human father = new Human("Father", true, 41, childes);
        Human grandfather1 = new Human("Grandfather1", true, 70, new ArrayList<>(Collections.singletonList(mother)));
        Human grandfather2 = new Human("Grandfather2", true, 70, new ArrayList<>(Collections.singletonList(father)));
        Human grandmother1 = new Human("Grandmother1", false, 69, new ArrayList<>(Collections.singletonList(mother)));
        Human grandmother2 = new Human("Grandmother2", false, 69, new ArrayList<>(Collections.singletonList(father)));

        family.add(grandfather1);
        family.add(grandfather2);
        family.add(grandmother1);
        family.add(grandmother2);
        family.add(father);
        family.add(mother);
        family.add(child1);
        family.add(child2);
        family.add(child3);

        for (Human human : family) {
            System.out.println(human);
        }
    }

    public static class Human {

        private final String name;
        private final boolean sex;
        private final int age;
        private final ArrayList<Human> children;


        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children != null ? new ArrayList<>(children) : new ArrayList<>();
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
