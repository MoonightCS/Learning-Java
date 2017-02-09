package com.javarush.task.task24.task2413;

/*
Арканоид(9)
Теперь займемся классом Canvas.
Он у нас будет содержать матрицу (двумерный массив), куда мы будем «рисовать«.
У матрицы есть ширина и высота.
А еще будем в ней хранить не числа (int), а символы (char).

Надо:
а) Добавить в класс два приватных поля width и height.
б) Добавить в класс приватное поле matrix (char[][]).
в) Добавить конструктор с двумя параметрами типа int (width и height), поле matrix должно быть инициализировано пустым массивом размерностью [height+2][width+2].
г) Добавить геттеры и сеттеры для всех приватных полей класса.


 */
public class Canvas {

    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[this.height + 2][this.width + 2];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
