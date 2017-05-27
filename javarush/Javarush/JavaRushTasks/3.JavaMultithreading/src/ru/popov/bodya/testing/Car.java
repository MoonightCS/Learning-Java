package ru.popov.bodya.testing;

import java.util.ArrayList;

class Car {
    public ArrayList ArrayListcreatePoliceCars(int count) {
        ArrayList result = new ArrayList();

        for (int i = 0; i < count; i++) {

            final int number = i;
            result.add(new Car() {
                public String toString() {
                    return "" + number;
                }
            });
        }
        return result;
    }
}