package ru.popov.bodya;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println(ThreadHelper.fib(6));
        System.out.println(ProThreadHelper.fib(6));

    }
}
