package ru.popov.bodya;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/spring.xml");
        App app = ctx.getBean(App.class);
        Event event = ctx.getBean(Event.class);
        Event event2 = ctx.getBean(Event.class);
        app.logEvent("Some event for 1", event);
        app.logEvent("Some event for 2", event2);
    }


    private void logEvent(String msg, Event event) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }
}
