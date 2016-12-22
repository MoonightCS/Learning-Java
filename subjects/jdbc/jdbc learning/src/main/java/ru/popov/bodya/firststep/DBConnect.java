package ru.popov.bodya.firststep;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DBConnect {

    private static String url;
    private static String username;
    private static String password;

    public static void main(String[] args) {

        readRootData();
        newDbConnection();

    }

    private static void newDbConnection() {
        try {

            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.out.println("SQL exception with driver");
        }

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            //statement.execute("insert into mydbtest.users (name, age, email) values (\"julia\", 30, \"julia@mail\")");
            statement.executeUpdate("update mydbtest.users set users.name = 'Dimka' where users.id = 3");

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
