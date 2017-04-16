package ru.popov.bodya;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event) {
        System.out.print(event.toString());
    }
}
