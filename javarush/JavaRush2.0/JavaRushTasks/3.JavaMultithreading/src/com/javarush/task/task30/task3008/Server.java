package com.javarush.task.task30.task3008;

/*
Приступим к самому важному – написанию класса Server. Сервер должен поддерживать
множество соединений с разными клиентами одновременно. Это можно реализовать с
помощью следующего алгоритма:

- Сервер создает серверное сокетное соединение.

- В цикле ожидает, когда какой-то клиент подключится к сокету.

- Создает новый поток обработчик Handler, в котором будет происходить обмен

сообщениями с клиентом.

- Ожидает следующее соединение.

Добавь:

1)	В класс Server приватный статический вложенный класс Handler, унаследованный от

Thread.

2)	В класс Handler поле socket типа Socket.

3)	В класс Handler конструктор, принимающий в качестве параметра Socket и

инициализирующий им соответствующее поле класса.

4)	Метод main класса Server, должен:

а) Запрашивать порт сервера, используя ConsoleHelper.

б) Создавать серверный сокет java.net.ServerSocket, используя порт из предыдущего пункта.

в) Выводить сообщение, что сервер запущен.

г) В бесконечном цикле слушать и принимать входящие сокетные соединения только что созданного

серверного сокета.

д) Создавать и запускать новый поток Handler, передавая в конструктор сокет из предыдущего пункта.

е) После создания потока обработчика Handler переходить на новый шаг цикла.

ж) Предусмотреть закрытие серверного сокета в случае возникновения исключения.

з) Если исключение Exception все же произошло, поймать его и вывести сообщение

об ошибке.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }

    public static void main(String[] args) {

        int serverPort = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {

            ConsoleHelper.writeMessage("Сервер запущен");

            while (true) {

                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
