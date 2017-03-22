package ru.popov.bodya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("http://javarush.ru/images/lectures/javarush-quest-4-768x422.png", Paths.get("/Users/bogdanpopov/Desktop/fodler_for_testing/file_3.png"));
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {

        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        Path tmp = Files.createTempFile("temp-", ".tmp");
        Files.copy(inputStream, tmp, StandardCopyOption.REPLACE_EXISTING);

        String fileName = downloadDirectory.toString() + urlString.substring(urlString.lastIndexOf("/"));
        Path pathToMove = Paths.get(fileName);
        Files.move(tmp, pathToMove);
        return pathToMove;
    }
}
