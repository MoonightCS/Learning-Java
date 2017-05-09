package ru.popov.bodya;

import ru.popov.bodya.executor.Executor;
import ru.popov.bodya.executor.ResultHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DbProcessor dbProcessor = new DbProcessor();
        Connection connection = dbProcessor.getConnection();

        String query = "select name from users where id = 2";
        String name = Executor.execQuery(connection, query, new ResultHandler<String>() {
            @Override
            public String handle(ResultSet resultSet) throws SQLException {
                resultSet.next();
                return resultSet.getString("name");
            }
        });

        String nameLambda = Executor.execQuery(connection, query, resultSet -> {
            resultSet.next();
            return resultSet.getString("name");
        });

        System.out.println("User name with id = 1 -> " + name);
        System.out.println("User name with id = 1 -> " + nameLambda);

        connection.close();
    }


}
