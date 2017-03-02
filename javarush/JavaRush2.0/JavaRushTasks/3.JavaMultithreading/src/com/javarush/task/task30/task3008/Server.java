package com.javarush.task.task30.task3008;

/*
Пришло время написать главный метод класса Handler, который будет вызывать все
вспомогательные методы, написанные ранее. Реализуем метод void run() в классе Handler.

Он должен:
1. Выводить сообщение, что установлено новое соединение с удаленным адресом, который можно получить с помощью метода getRemoteSocketAddress.
2. Создавать Connection, используя поле socket.
3. Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента.
4. Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED).
Подумай, какой метод подойдет для этого лучше всего.
5. Сообщать новому участнику о существующих участниках.
6. Запускать главный цикл обработки сообщений сервером.
7. Обеспечить закрытие соединения при возникновении исключения.
8. Отловить все исключения типа IOException и ClassNotFoundException, вывести в консоль информацию, что произошла ошибка при обмене данными с удаленным адресом.
9. После того как все исключения обработаны, если п.11.3 отработал и возвратил нам имя,
мы должны удалить запись для этого имени из connectionMap и разослать всем остальным участникам сообщение с типом USER_REMOVED и сохраненным именем.
10. Последнее, что нужно сделать в методе run() – вывести сообщение, информирующее что соединение с удаленным адресом закрыто.

Наш сервер полностью готов. Попробуй его запустить.



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

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с удаленным клиентом с адресом: " + socket.getRemoteSocketAddress());
            Connection connection = null;
            String clientName = null;

            try {
                connection = new Connection(socket);
                clientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                sendListOfUsers(connection, clientName);
                serverMainLoop(connection, clientName);

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            }

            if (clientName != null) {
                connectionMap.remove(clientName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
            }

            ConsoleHelper.writeMessage(String.format("Соединение с удаленным адресом (%s) закрыто.", socket.getRemoteSocketAddress()));


        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String textForMessage = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, textForMessage));
                } else {
                    System.out.println("Во время загрузки сообщения произошла ошибка");
                }
            }
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
