package ru.popov.bodya.java8tutorial.defaultmethods;

public class Main {

    public static void main(String[] args) {

        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a);
            }
        };


        System.out.println(formula.calculate(100));
        System.out.println(formula.calculate(16));

    }

}
