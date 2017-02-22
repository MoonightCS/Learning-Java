package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
Создай свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
UncaughtExceptionHandler должен маскировать звездочками имя трэда и выводить в консоль описание возникшей ошибки.
«Thread-0» должно быть заменено на «********».
«Thread-4321» должно быть заменено на «***********».
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String newName = t.getName().replaceAll("[\\w, -]", "*");
                String newMessage = e.getMessage().replace(t.getName(), newName);
                e = new Exception(newMessage, e);
                System.out.println(e.getMessage());
                t.setName(newName);
            }
        };
    }

    @Override
    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        Thread th = new Thread(new Solution(new TimerTask() {
            @Override
            public void run() {
                throw new Error();
            }
        }));
        th.start();
    }
}