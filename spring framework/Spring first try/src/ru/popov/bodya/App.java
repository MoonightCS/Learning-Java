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
//        App app = (App) ctx.getBean("app");
        App app = ctx.getBean(App.class);
        app.logEvent("Some event for 1", ctx);
        app.logEvent("Some event for 2", ctx);
    }

    private void logEvent(String msg, ApplicationContext ctx) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        Event event = ctx.getBean(Event.class);
        event.setMsg(message);
        eventLogger.logEvent(event);
    }
}
