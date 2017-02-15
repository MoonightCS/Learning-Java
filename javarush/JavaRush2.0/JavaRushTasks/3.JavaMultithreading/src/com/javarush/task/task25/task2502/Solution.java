package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.List;

/* 
Машину на СТО не повезем!
Инициализируй поле wheels используя данные из loadWheelNamesFromDB.
Выкинь исключение в случае некорректных данных.

Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.

*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;


        public Car() {
            wheels = new ArrayList<>();
            String[] arrForTest = loadWheelNamesFromDB();

            if (!isFourWheels(arrForTest)) {
                throw new IllegalArgumentException();
            }

            for (String wheel : arrForTest) {
                if (isWheel(wheel)) {
                    wheels.add(Wheel.valueOf(wheel));
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }

        protected String[] loadWheelNamesFromDB() {
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }

        private static boolean isFourWheels(String[] wheels) {
            return wheels.length == 4;
        }

        private static boolean isWheel(String str) {
            for (Wheel wheel : Wheel.values()) {
                if (wheel.name().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
    }
}
