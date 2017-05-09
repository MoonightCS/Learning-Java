package ru.popov.bodya.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class TransactionsExample {

    public void execUpdated(Connection connection, String[] updates) {
        try {
            connection.setAutoCommit(false);
            for (String update : updates) {
                Statement statement = connection.createStatement();
                statement.execute(update);
                statement.close();
            }
            connection.commit();
        } catch (SQLException e) {

            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    public void execUpdatedWithPreparedStatement(Connection connection, Map<Integer, String> idToName) {

        try {
            connection.setAutoCommit(false);
            String update = "insert into users(id, name) values(?, ?)";
            PreparedStatement statement = connection.prepareStatement(update);
            for (Map.Entry<Integer, String> entry : idToName.entrySet()) {
                statement.setInt(1, entry.getKey());
                statement.setString(2, entry.getValue());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }

    }
}
