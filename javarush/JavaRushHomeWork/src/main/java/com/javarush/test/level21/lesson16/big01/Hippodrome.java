package com.javarush.test.level21.lesson16.big01;


import java.util.ArrayList;

/*
Задание 10
Еще нужно написать метод print класса Hippodrome.
В нем тоже все просто: в цикле для каждой лошади вызываем ее метод print.
Ну, и еще выведи после цикла пару пустых строк: System.out.println() - чтобы было красивее.
 */

public class Hippodrome {

    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void print() {
        for (Horse horse: getHorses()) {
            horse.print();
            System.out.printf("\n\n");
        }
    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public static void main(String[] args) {
        game = new Hippodrome();
        for (int i = 0; i < 3; i++) {
            game.getHorses().add(new Horse("Horse" + i, 3, 0));
        }
    }
}
