package ru.popov.bodya.mysoltuions;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println(ThreadHelper.fib(15));
        System.out.println(ProThreadHelper.fib(15));
        System.out.println(ExecutorServiceFibo.fib(15));

    }
}
