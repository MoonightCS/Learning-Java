package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    private static Map<String, String> properties = new HashMap<>();
    private static Properties propertiesData = new Properties();

    public static void main(String[] args) throws Exception {
        final String fileName = "/Users/bogdanpopov/Desktop/learning-java/javarush/JavaRushHomeWork/src/test/resources/test.properties";
        properties.put("website","https://ru.wikipedia.org/");
        properties.put("language","Russian");
        properties.put("key","value");
        Map<String, String> test = new HashMap<>(properties);
        save(new FileOutputStream(fileName));
        properties.clear();
        load(new FileInputStream(fileName));

        //Test
        System.out.println("before save");
        for (Map.Entry<String, String> entry: test.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("\nafter load");
        for (Map.Entry<String, String> entry: properties.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
    public static void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String fileName = reader.readLine();
        InputStream inputStream = new FileInputStream(fileName);
        reader.close();
        load(inputStream);
        inputStream.close();
    }

    public static void save(OutputStream outputStream) throws Exception {
        propertiesData.putAll(properties);
        propertiesData.store(outputStream, "yo");
    }

    public static void load(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        propertiesData.load(inputStream);
        for (String prop : propertiesData.stringPropertyNames()) {
            properties.put(prop, propertiesData.getProperty(prop));
        }
        reader.close();
    }
}
