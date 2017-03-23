package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.Locale;

public class Restaurant {

    public static void main(String[] args) {


        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Ivanov");
        tablet.addObserver(cook);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        tablet.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        //directorTablet.printCookWorkloading();
        //directorTablet.printActiveVideoSet();
        //directorTablet.printArchivedVideoSet();

    }
}

