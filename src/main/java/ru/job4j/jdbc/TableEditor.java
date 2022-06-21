package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

/**
 * @author Artem Polshchak on 21.06.2022.
 * @project job4j_design
 */
public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) throws ClassNotFoundException, SQLException {
        this.properties = properties;
        initConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Properties getProperties() {
        return properties;
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(getProperties().getProperty("hibernate.connection.driver_class"));
        String url  = getProperties().getProperty("hibernate.connection.url");
        String login = getProperties().getProperty("hibernate.connection.username");
        String password = getProperties().getProperty("hibernate.connection.password");
        setConnection(DriverManager.getConnection(url, login, password));
    }

    public void createTable(String tableName) throws Exception {
        try (Statement statement = getConnection().createStatement()) {
            String sql = "create table if not exists " + tableName + "();";
            statement.executeUpdate(sql);
        }
    }

    public void dropTable(String tableName) throws Exception {
        try (Statement statement = getConnection().createStatement()) {
            String sql = "drop table " + tableName + ";";
            statement.executeUpdate(sql);
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        try (Statement statement = getConnection().createStatement()) {
            String sql = "alter table " + tableName + " add " + columnName + " " + type + ";";
            statement.executeUpdate(sql);
        }
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        try (Statement statement = getConnection().createStatement()) {
            String sql = "alter table " + tableName + " drop column " + columnName + ";";
            statement.executeUpdate(sql);
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        try (Statement statement = getConnection().createStatement()) {
            String sql = "alter table " + tableName + " rename column " + columnName + " to " + newColumnName + ";";
            statement.executeUpdate(sql);
        }
    }

    public void getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = getConnection().createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        System.out.println(buffer);
    }

    @Override
    public void close() throws Exception {
        if (getConnection() != null) {
            getConnection().close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream io = ConnectionDemo.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TableEditor tableEditor = new TableEditor(config);
        tableEditor.initConnection();
        tableEditor.createTable("new_test_table");
        tableEditor.getTableScheme("new_test_table");
        tableEditor.addColumn("new_test_table", "id", "serial primary key");
        tableEditor.getTableScheme("new_test_table");
        tableEditor.addColumn("new_test_table", "name", "varchar(20)");
        tableEditor.getTableScheme("new_test_table");
        tableEditor.addColumn("new_test_table", "last_name", "varchar(20)");
        tableEditor.getTableScheme("new_test_table");
        tableEditor.renameColumn("new_test_table", "last_name", "second_name");
        tableEditor.getTableScheme("new_test_table");
        tableEditor.dropColumn("new_test_table", "name");
        tableEditor.getTableScheme("new_test_table");
        tableEditor.dropTable("new_test_table");
        tableEditor.close();
    }
}