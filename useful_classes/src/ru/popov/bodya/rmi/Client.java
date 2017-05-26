package ru.popov.bodya.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static final String UNIQUE_BINDING_NAME = "server.reverse";

    public static void main(String[] args) throws Exception {
        //создание реестра расшареных объетов
        final Registry registry = LocateRegistry.getRegistry(9988);

        //получаем объект (на самом деле это proxy-объект)
        Reverse service = (Reverse) registry.lookup(UNIQUE_BINDING_NAME);

        //Вызываем удаленный метод
        String result = service.reverse("Home sweet home.");
        System.out.println("object = " + service + " with result = " + result);
    }
}
