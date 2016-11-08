package stream;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CounterOfJavaFiles {

    public static void main(String[] args) throws IOException {

        Path dir = Paths.get("/Users/bogdanpopov/Desktop/Learning-Java/");
        try (Stream<Path> files = Files.walk(dir)) {
            long count = files.filter((path -> path.toString().endsWith(".java")))
                    .flatMap((CounterOfJavaFiles::getLines))   //flatMap((path -> getLines(path)))
                    .filter((s -> s.contains("main")))
                    .peek((System.out::println))
                    .count();
            System.out.println(count);
        }


    }

    private static Stream<String> getLines(Path path) {

        try {
            return Files.lines(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

}
