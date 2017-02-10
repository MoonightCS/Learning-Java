package ru.popov.bodya;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class WorkWithProperties {

    private static Map<String, String> properties = new HashMap<>();
    private static Properties propertiesData = new Properties();

    public static void main(String[] args) throws Exception {
        fillInPropertiesMap();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String fileName = reader.readLine();
        InputStream inputStream = new FileInputStream(fileName);
        reader.close();
        load(inputStream);
    }

    public static void save(OutputStream outputStream) throws Exception {
        if (propertiesData.size() > 0) {
            propertiesData.putAll(properties);
        }
        propertiesData.store(outputStream, "");
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
