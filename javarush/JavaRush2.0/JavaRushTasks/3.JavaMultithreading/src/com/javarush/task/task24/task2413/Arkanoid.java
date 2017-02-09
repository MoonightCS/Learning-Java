package com.javarush.task.task24.task2413;

/*
Арканоид(5)
Чего еще не хватает классу Arkanoid?
Во-первых ему нужен метод run(), в котором будет описана основная логика программы.
Еще нужен метод move() — который будет двигать на один шаг все объекты требующие движения.
Создай методы run() и move().

Еще нам понадобится НЕ приватная статическая переменная game типа Arkanoid, которая будет хранить ссылку на созданный экземпляр класса Arkanoid.

Выглядеть это должно примерно так:
static Arkanoid game;
 */

import java.util.List;

public class Arkanoid {

    static Arkanoid game;

    private int width;
    private int height;
    private Ball ball;
    private Stand stand;

    private List<Brick> bricks;

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void run() {

    }

    public void move() {

    }

    public Ball getBall() {
        return ball;
    }

    public Stand getStand() {
        return stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void main(String[] args) {
    }
}
