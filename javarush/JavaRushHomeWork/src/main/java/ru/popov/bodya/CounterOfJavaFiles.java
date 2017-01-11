package ru.popov.bodya;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CounterOfJavaFiles {


    public static void main(String[] args) throws IOException {

        Path dir = Paths.get("/Users/user/Desktop/learning-java/javarush/JavaRushHomeWork/src/main/java/com/javarush/test");
        try (Stream<Path> files = Files.walk(dir)) {
            long count = files.filter((path -> path.toString().endsWith("Solution.java")))
                    .peek((System.out::println))
                    .count();
            System.out.println(count);
        }


    }


}