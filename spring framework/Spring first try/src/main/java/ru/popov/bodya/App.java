package ru.popov.bodya;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("appWithCache");

        Event event = ctx.getBean(Event.class);
        app.logEvent("Some event for 1", event);

        Event event2 = ctx.getBean(Event.class);
        app.logEvent("Some event for 2", event2);
        ctx.close();
    }


    private void logEvent(String msg, Event event) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }
}
