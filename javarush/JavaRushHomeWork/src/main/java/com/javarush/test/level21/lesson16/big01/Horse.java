package com.javarush.test.level21.lesson16.big01;

/*

Задание 13
Теперь вернемся к методу print класса Horse.
Т.к. мы работаем с консолью, то все лошади на бегах будут выглядеть примерно так:
........Sleven                       <- лошадь Слевин
....Lucky                            <- лошадь Лаки
..........Gomer                      <- лошадь Гомер

Другими словами, в методе print надо вывести на экран строку состоящую из точек и имени лошади.
Количество точек равно distance, округленному до целого числа.

 */

public class Horse {

    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move() {
        distance += speed * Math.random();
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            stringBuilder.append(".");
        }
        stringBuilder.append(name);
        System.out.println(stringBuilder.toString());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

}
