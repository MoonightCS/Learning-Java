package ru.popov.bodya.statement;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

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

