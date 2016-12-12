package ru.popov.bodya.usage;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DBProcessor {

    private Connection connection = null;

    public DBProcessor() throws SQLException {
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);
    }

    public Connection getConnection(String url, String username, String password) throws SQLException {
        if (connection != null) {
            return connection;
        }
        return DriverManager.getConnection(url, username, password);
    }
}

