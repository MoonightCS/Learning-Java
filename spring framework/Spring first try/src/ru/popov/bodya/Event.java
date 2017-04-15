package ru.popov.bodya;

import java.util.Date;

public class Event {
    private int id;
    private String msg;
    private Date date;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Event(Date date) {
        id = (int) (Math.random() * 101);
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}
