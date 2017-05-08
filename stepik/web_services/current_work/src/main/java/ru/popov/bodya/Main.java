package ru.popov.bodya;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DbProcessor dbProcessor = new DbProcessor();
        Connection connection = dbProcessor.getConnection();
    }

}
