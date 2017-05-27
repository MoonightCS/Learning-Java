package ru.popov.bodya.rmi;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static final String UNIQUE_BINDING_NAME = "server.reverse";

    public static void main(String[] args) throws Exception {
        //создание объекта для удаленного доступа
        final ReverseImpl service = new ReverseImpl();

        //создание реестра расшареных объетов
        final Registry registry = LocateRegistry.createRegistry(9988);
        //создание "заглушки" – приемника удаленных вызовов
        Remote stub = UnicastRemoteObject.exportObject(service, 0);
        //регистрация "заглушки" в реесте
        registry.bind(UNIQUE_BINDING_NAME, stub);

        System.out.println(service);

        //усыпляем главный поток, иначе программа завершится
        Thread.sleep(Integer.MAX_VALUE);

    }

}
