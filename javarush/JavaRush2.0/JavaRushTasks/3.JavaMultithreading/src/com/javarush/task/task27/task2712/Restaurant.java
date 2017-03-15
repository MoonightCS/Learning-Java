package com.javarush.task.task27.task2712;

/*
3. Пишем main.

Для объекта Observable добавляем свой объект Observer. См. п.2 и описание паттерна в wikipedia

Называем повара, имя не влияет на тесты. В моем варианте - это Amigo :)

Сверим выводы в консоль. Пример моего вывода:

Your order: [Soup] of Tablet{number=5}
 */

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {

    public static void main(String[] args) {

        Waiter waiter = new Waiter();
        Cook cook = new Cook("Bodya");
        Tablet tablet = new Tablet(5);

        cook.addObserver(waiter);
        tablet.addObserver(cook);
        tablet.createOrder();

    }
}

