package com.javarush.task.task30.task3008;

/*
Этап второй, но не менее важный – отправка клиенту (новому участнику) информации об
остальных клиентах (участниках) чата.

Для этого:
1) Добавь приватный метод void sendListOfUsers(Connection connection, String userName) throws IOException, где connection – соединение с участником,
которому будем слать информацию, а userName – его имя. Метод должен:
2) Пройтись по connectionMap.
3) У каждого элемента из п.2 получить имя клиента, сформировать команду с типом USER_ADDED и полученным именем.
4) Отправить сформированную команду через connection.
5) Команду с типом USER_ADDED и именем равным userName отправлять не нужно, пользователь и так имеет информацию о себе.


 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String clientName : connectionMap.keySet()) {
                if (!clientName.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, clientName));
                }
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            boolean accepted = false;
            String name = null;

            while (!accepted) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    name = message.getData();
                    if (!name.isEmpty() && !connectionMap.containsKey(name)) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        accepted = true;
                    }
                }
            }
            return name;
        }

    }

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Connection connection : connectionMap.values()) {
                connection.send(message);
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Во время отправки сообщения произошла ошибка");
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
