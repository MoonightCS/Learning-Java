package ru.popov.bodya.stream;

import java.util.stream.Stream;

public class FibonacciWithStream {

    public static void main(String[] args) {

        Stream.generate(new FibonacciSupplier())
                .limit(15)
                .forEach(System.out::println);

    }

}
