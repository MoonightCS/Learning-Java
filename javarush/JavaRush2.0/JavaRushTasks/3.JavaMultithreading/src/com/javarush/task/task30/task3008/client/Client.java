package com.javarush.task.task30.task3008.client;

/*
3) Создай внутренний класс SocketThread унаследованный от Thread в классе Client.
Он будет отвечать за поток, устанавливающий сокетное соединение и читающий сообщения сервера. Класс должен иметь публичный модификатор доступа.
4) Создай поле Connection connection в классе Client. Используй модификатор доступа, который позволит обращаться к этому полю из класса потомков,
но запретит обращение из других классов вне пакета.
5) Добавь приватное поле-флаг boolean clientConnected в класс Client. Проинициализируй его значением false. В дальнейшем оно будет устанавливаться в true,
если клиент подсоединен к серверу или в false в противном случае. При объявлении этого поля используй ключевое слово, которое позволит
 гарантировать что каждый поток, использующий поле clientConnected, работает с актуальным, а не кэшированным его значением.
 */

import com.javarush.task.task30.task3008.Connection;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {

    }
}
