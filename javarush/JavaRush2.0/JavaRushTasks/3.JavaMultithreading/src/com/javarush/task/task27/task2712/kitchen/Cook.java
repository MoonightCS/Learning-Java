package com.javarush.task.task27.task2712.kitchen;

/*
1. Создадим класс Cook(Повар) в пакете kitchen, он будет готовить. Пусть в конструкторе приходит его имя, которое выводится методом toString.

2. Tablet создает заказы, а Cook их обрабатывает. Расставь правильно Observer и Observable между Tablet и Cook.

3. Метод void update(Observable observable, Object arg), который необходимо реализовать, принимает два параметра.

-observable - объект, который отправил нам значение

-arg - само значение, в нашем случае - это объект Order

На данном этапе мы будем лишь имитировать обработку и выведем в консоль "Start cooking - " + order

3. Пишем main.

Для объекта Observable добавляем свой объект Observer. См. п.2 и описание паттерна в wikipedia

Называем повара, имя не влияет на тесты. В моем варианте - это Amigo :)

Сверим выводы в консоль. Пример моего вывода:

Your order: [Soup] of Tablet{number=5}

Start cooking - Your order: [Soup] of Tablet{number=5}
4. Не забудь сразу после создания заказа и вывода информации о нем в консоль (найдите это место в коде) сделать следующее:
4.1. Установить флаг setChanged()
4.2. Отправить обсерверу заказ - notifyObservers(order);
5. Также внесем небольшое изменение. Сделай так чтобы метод createOrder возвращал текущий заказ или null, если заказ создать не удалось.
 */

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {

    private final String name;


    public Cook(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable observable, Object arg) {
        ConsoleHelper.writeMessage("Start cooking - " + arg);
        setChanged();
        notifyObservers(arg);
    }

}
