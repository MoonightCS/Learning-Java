package com.javarush.test.level21.lesson16.big01;


import java.util.ArrayList;

/*
Задание 8
В методе run сделай цикл от 1 до 100. Это и будет наш забег.
В теле цикла вызываем сначала move, затем print.
Чтобы весь цикл не отработал за долю секунды - добавь в него еще Thread.sleep(200);


 */

public class Hippodrome {

    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void print() {

    }

    public void move() {

    }

    public void run() {

    }

    public static void main(String[] args) {
        game = new Hippodrome();
        for (int i = 0; i < 3; i++) {
            game.getHorses().add(new Horse("Horse" + i, 3, 0));
        }
    }
}
