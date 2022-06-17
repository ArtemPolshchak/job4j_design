package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Artem.polschak@gmail.com on 16.06.2022.
 * @project job4j_design
 * 0. JDBC [#6863]
 */

public class ConnectionDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Properties config = new Properties();
        try (InputStream io = ConnectionDemo.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Class.forName(config.getProperty("hibernate.connection.driver_class"));
        String url  = config.getProperty("hibernate.connection.url");
        String login = config.getProperty("hibernate.connection.username");
        String password = config.getProperty("hibernate.connection.password");

        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
