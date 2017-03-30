package ru.popov.bodya;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        URL url = URLDemo.class.getResource("URLDemo.class");
        System.out.println(url);
        try (InputStream inputStream = url.openStream()) {
            byte buffer[] = new byte[128];
            int bytesRead = inputStream.read(buffer);
            for (int i = 0; i < bytesRead; i++) {
                if (i % 32 == 0) {
                    System.out.println();
                }
                System.out.printf("%02X ", buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
