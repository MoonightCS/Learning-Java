package com.javarush.task.task23.task2312;

/*
Теперь займемся классом SnakeSection.
Он будет описывать один кусочек змеи.

А у каждого кусочка что есть?
Правильно! Координаты.

Добавь два поля в класс SnakeSection: x и y типа int.
Добавь для них getter’ы и конструктор с двумя параметрами типа int.

 */

public class SnakeSection {
    private int x;
    private int y;

    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
