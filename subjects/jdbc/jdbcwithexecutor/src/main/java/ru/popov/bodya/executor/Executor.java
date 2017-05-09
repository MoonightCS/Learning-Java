package ru.popov.bodya.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {

    public static <T> T execQuery(Connection connection, String query, ResultHandler<T> handler) throws SQLException {

        T value;
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            value = handler.handle(resultSet);
        }
        return value;
    }

    public static int execUpdate(Connection connection, String update) {
        int updated = 0;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(update);
            updated = stmt.getUpdateCount();
            stmt.close();
            return updated;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

}
