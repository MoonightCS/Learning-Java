package ru.popov.bodya;

import java.text.DateFormat;
import java.util.Date;

public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Event(Date date, DateFormat df) {
        id = (int) (Math.random() * 101);
        this.date = date;
        this.df = df;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
