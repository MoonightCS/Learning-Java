package ru.popov.bodya.usage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Main {

    private static String url;
    private static String username;
    private static String password;

    public static void main(String[] args) {
        DBProcessor db = null;
        readRootData();
        try {
            db = new DBProcessor();
        } catch (SQLException e) {
            System.out.println("SQL Exception with driver");
        }

        assert db != null;
        try (Connection connection = db.getConnection(url, username, password);
             Statement statement = connection.createStatement();) {
            String query = "select * from mydbtest.users";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int age = resultSet.getInt(3);
                String name = resultSet.getString(2);
                String email = resultSet.getString(4);
                Product product = new Product(id, age, name, email);
                System.out.println(product);
            }

        } catch (SQLException e) {
            System.out.println("SQL exception with connection");
        }
    }

    private static void readRootData() {
        File f = new File("src/main/resources/data.txt");

        try (BufferedReader fin = new BufferedReader(new FileReader(f))) {
            url = fin.readLine();
            username = fin.readLine();
            password = fin.readLine();
        } catch (IOException e) {
            System.out.println("IO exception");
        }
    }
}
