package ru.popov.bodya.java8tutorial.lambdaexpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {

        // Каждое лямбда-выражение определенного типа (представленного интерфейсом) будет сопоставлено объявленному методу.

        SimpleLine line = () -> System.out.println("___________\n");

        oldStyle();
        line.print();
        newStyle();
        line.print();
        newStyleWithRef();
    }

    private static void oldStyle() {

        List<String> names = Arrays.asList("Bodya", "Maryana", "Dima", "Alex");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String s : names) {
            System.out.println(s);
        }
    }


    private static void newStyle() {

        List<String> names = Arrays.asList("Bodya", "Maryana", "Dima", "Alex");
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
        names.forEach((s) -> System.out.println(s));


    }

    private static void newStyleWithRef() {

        // The only condition (for method reference) that the methods need
        // to follow is that they should be assignable to any FunctionalInterface

        List<String> names = Arrays.asList("Bodya", "Maryana", "Dima", "Alex");
        Collections.sort(names, String::compareTo);
        names.forEach(System.out::println);

    }

    @FunctionalInterface
    interface SimpleLine {

        void print();

    }


}


