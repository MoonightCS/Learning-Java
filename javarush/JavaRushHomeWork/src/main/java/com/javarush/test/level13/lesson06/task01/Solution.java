package com.javarush.test.level13.lesson06.task01;

/* Dog, Cat и Mouse
1. Создать классы Dog, Cat и Mouse.
2. Реализовать интерфейсы в добавленных классах, учитывая что:
- Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
- Мышь(Mouse) может передвигаться и может быть съедена.
- Собака(Dog) может передвигаться и съесть кого-то.
*/

public class Solution {

    public interface Moveable {
        void move();
    }

    public interface Eatable {
        void eaten();
    }

    public interface Eat {
        void eat();
    }

    private class Mouse implements Moveable, Eatable {
        @Override
        public void move() {

        }

        @Override
        public void eaten() {

        }
    }

    private class Dog implements Eat, Moveable {
        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }

    private class Cat implements Moveable, Eatable, Eat {
        @Override
        public void move() {

        }

        @Override
        public void eaten() {

        }

        @Override
        public void eat() {

        }
    }
}
