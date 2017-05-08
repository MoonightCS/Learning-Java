package ru.popov.bodya;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbProcessor {

    private Connection connection = null;
    private UrlData urlData;

    public DbProcessor() {
        try {
            getAndRegisterDriver();
            urlData = readRootDataAndParseToURL();
            connection = createConnection(urlData.getUrl(), urlData.getUser(), urlData.getPassword());
        } catch (IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


    private UrlData readRootDataAndParseToURL() {
        File f = new File("src/main/resources/data.txt");
        urlData = new UrlData();

        try (BufferedReader fin = new BufferedReader(new FileReader(f))) {
            urlData.setUrl(fin.readLine());
            urlData.setUser(fin.readLine());
            urlData.setPassword(fin.readLine());
        } catch (IOException e) {
            System.out.println("IO Exception in reading the file");
        }
        return urlData;
    }

    private void getAndRegisterDriver() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        DriverManager.registerDriver(driver);
    }

    private class UrlData {
        private String url;
        private String user;
        private String password;

        private String getUrl() {
            return url;
        }

        private String getUser() {
            return user;
        }

        private String getPassword() {
            return password;
        }

        private void setUrl(String url) {
            this.url = url;
        }

        private void setUser(String user) {
            this.user = user;
        }

        private void setPassword(String password) {
            this.password = password;
        }
    }

}
