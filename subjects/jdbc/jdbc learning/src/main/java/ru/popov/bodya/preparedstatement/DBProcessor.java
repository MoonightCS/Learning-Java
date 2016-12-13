package ru.popov.bodya.preparedstatement;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

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

