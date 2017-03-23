package com.javarush.task.task27.task2712.kitchen;

/*

5. У нас все завязано на работу с консолью. Однако, при возникновении исключений, наше приложение умрет.
Чтобы узнать причину — добавим в Tablet статическое поле logger типа java.util.logging.Logger, инициализированное именем класса (Logger.getLogger(Tablet.class.getName())).

6. В методе createOrder класса Tablet обработаем исключения ввода-вывода.
Запишем в лог «Console is unavailable.«. Уровень лога — SEVERE — это самый серьезный уровень, мы не можем работать.
Также в методе createOrder класса Tablet должен быть создан новый заказ.

7. Надо начинать тестировать наше приложение.
Добавьте в main создание планшета и создание заказа — new Tablet(5).createOrder();
 */


import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {

    private final int number;
    protected List<Dish> dishes;
    private final Tablet tablet;
    private int cookingTime;

    public Order(Tablet tablet) throws IOException {
        number = tablet.getNumber();
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }


    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        } else {
            return "Your order: " + dishes.toString() + " of " + tablet.toString();
        }
    }

    public Tablet getTablet() {
        return tablet;
    }

    public int getTotalCookingTime() {
        cookingTime = 0;
        for (Dish dish : dishes) {
            cookingTime += dish.getDuration();
        }
        return cookingTime;
    }


    public List<Dish> getDishes() {
        return dishes;
    }
}
