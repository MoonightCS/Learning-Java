package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution {
    public static void main(String[] args) {
        Human grandfahter1 = new Human("Боря", true, 70, null, null);
        Human grandfahter2 = new Human("Владимир", true, 72, null, null);
        Human grandmother1 = new Human("Нина", false, 69, null, null);
        Human grandmother2 = new Human("Ася", false, 69, null, null);
        Human father = new Human("Валерий", true, 50, grandfahter2, grandmother2);
        Human mother = new Human("Наталья", false, 49, grandfahter1, grandmother2);
        Human child1 = new Human("Бодя", true, 21, father, mother);
        Human child2 = new Human("Юля", false, 30, father, mother);
        Human child3 = new Human("Артем", true, 25, father, mother);

        System.out.println(grandfahter1);
        System.out.println(grandfahter2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        //напишите тут ваш код
        private final String name;
        private final boolean sex;
        private final int age;
        private final Human father;
        private final Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
