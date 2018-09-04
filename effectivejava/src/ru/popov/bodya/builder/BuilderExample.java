package ru.popov.bodya.builder;

import static ru.popov.bodya.builder.NyPizza.*;
import static ru.popov.bodya.builder.Pizza.Topping.*;

public class BuilderExample {

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(Size.SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
        System.out.println(pizza.getToppings());
        System.out.println(calzone.getToppings());
    }
}
