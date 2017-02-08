package ru.popov.bodya;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public final class CounterOfJavaFiles {

    public static void main(String[] args) throws IOException {
        long finalCount = 0;
        finalCount += countJavaFilesInDir(Constants.MACBOOK_DIR);
        finalCount += countJavaFilesInDir(Constants.MAC_DIR_1);
        finalCount += countJavaFilesInDir(Constants.MAC_DIR_2);
        System.out.println(finalCount);
    }

    private static long countJavaFilesInDir(String dirPath) {
        Path dir = Paths.get(dirPath);
        long count = 0;
        try (Stream<Path> files = Files.walk(dir)) {
            count = files.filter((path -> path.toString().endsWith("Solution.java")))
                    .peek((System.out::println))
                    .count();
            return count;
        } catch (IOException e) {
            System.out.println("No direction!");
        }
        return count;
    }

    private static final class Constants {
        private static final String MACBOOK_DIR = "/Users/user/Desktop/learning-java/javarush/JavaRushHomeWork/src/main/java/com/javarush/test";
        private static final String MAC_DIR_1 = "/Users/bogdanpopov/Desktop/learning-java/javarush/JavaRushHomeWork/src/main/java/com/javarush/test";
        private static final String MAC_DIR_2 = "/Users/bogdanpopov/Desktop/learning-java/javarush/JavaRush2.0/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task";
    }


}