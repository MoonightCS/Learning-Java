package ru.popov.bodya.preparedstatement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class PreparedStatementUsage {

    private static String url;
    private static String username;
    private static String password;
    private static DBProcessor db;

    public static void main(String[] args) {
        readRootData();
        getDriver();

        String query = "insert into mydbtest.users (name, age, email) values (?, ?, ?)";

        try (Connection connection = db.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, "Xronik");
            preparedStatement.setInt(2, 14);
            preparedStatement.setString(3, "nikitathebest@yandex.ru");
            preparedStatement.execute();


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


    private static void getDriver(){
        try {
            db = new DBProcessor();
        } catch (SQLException e) {
            System.out.println("SQL Exception with driver");
        }
    }

}
