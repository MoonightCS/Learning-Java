package com.javarush.task.task25.task2506;

/*
Cоздай класс нити LoggingStateThread, которая будет выводить в консоль все состояния (State) переданной в конструктор нити.
Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
Метод main не участвует в тестировании.
 */
public class LoggingStateThread extends Thread {
    private Thread threadToLog;

    public LoggingStateThread(Thread threadToLog) {
        this.threadToLog = threadToLog;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        State currentState = this.threadToLog.getState();
        System.out.println(currentState);

        while (currentState != State.TERMINATED) {
            State newState = threadToLog.getState();
            if (currentState != newState) {
                currentState = newState;
                System.out.println(currentState);
            }
        }
    }
}