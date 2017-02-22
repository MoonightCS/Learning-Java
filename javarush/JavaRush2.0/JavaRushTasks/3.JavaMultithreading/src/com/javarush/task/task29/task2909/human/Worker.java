package com.javarush.task.task29.task2909.human;

public class Worker extends Human {
    private Human human;
    private double salary;
    public String company;

    public Worker(String name, int age) {
        super(name, age);
    }

    @Override
    public void live() {
        super.live();
    }

    public double getSalary() {
        return salary;
    }

    public void setSlr(double salary) {
        this.salary = salary;
    }
}