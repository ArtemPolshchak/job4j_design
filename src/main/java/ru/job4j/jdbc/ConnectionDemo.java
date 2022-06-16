package ru.job4j.jdbc;

import ru.job4j.io.Config;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Artem.polschak@gmail.com on 16.06.2022.
 * @project job4j_design
 * 0. JDBC [#6863]
 */

public class ConnectionDemo {
    private final Properties prs = new Properties();

    public String getValue(String key) {
        return this.prs.getProperty(key);
    }

    public void load(InputStream io) {
        try {
            this.prs.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionDemo connectionDemo = new ConnectionDemo();
        ClassLoader loader = ConnectionDemo.class.getClassLoader();

        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            connectionDemo.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Class.forName(connectionDemo.getValue("hibernate.connection.driver_class"));
        String url  = connectionDemo.getValue("hibernate.connection.url");
        String login = connectionDemo.getValue("hibernate.connection.username");
        String password = connectionDemo.getValue("hibernate.connection.password");

        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
