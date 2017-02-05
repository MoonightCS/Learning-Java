package ru.popov.bodya;

import java.util.List;

public class Main {


    public static void main(String[] args) throws CloneNotSupportedException {
        Class[] interfaces = List.class.getInterfaces();
        for (Class clazz : interfaces) {
            System.out.println(clazz);
        }
        Main main = new Main();

    }


}
