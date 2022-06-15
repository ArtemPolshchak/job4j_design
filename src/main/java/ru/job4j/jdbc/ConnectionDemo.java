package ru.job4j.jdbc;

import ru.job4j.io.Config;
import java.sql.*;

/**
 * @author Artem.polschak@gmail.com on 16.06.2022.
 * @project job4j_design
 * 0. JDBC [#6863]
 */
public class ConnectionDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Config config = new Config("C:\\projects\\job4j_design\\src\\main\\resources\\app.properties");
        config.load();

        Class.forName(config.value("hibernate.connection.driver_class"));
        String url  = config.value("hibernate.connection.url");
        String login = config.value("hibernate.connection.username");
        String password = config.value("hibernate.connection.password");

        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
