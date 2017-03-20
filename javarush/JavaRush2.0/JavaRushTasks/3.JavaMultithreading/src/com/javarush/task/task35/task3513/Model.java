package com.javarush.task.task35.task3513;
/*
Займемся реализацией класса Model. Он будет ответственен за все манипуляции производимые с игровым полем.

Но чтобы как-то манипулировать игровым полем, неплохо было бы для начала его создать!

Нам понадобятся:
1. Приватная константа FIELD_WIDTH = 4, определяющая ширину игрового поля.
2. Приватный двумерный массив gameTiles состоящий из объектов класса Tile.
3. Конструктор без параметров инициализирующий игровое поле и заполняющий его пустыми плитками.
 */

public class Model {

    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    public Model() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
    }
}
