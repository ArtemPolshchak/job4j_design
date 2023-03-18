package ru.job4j.jdbc;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Artem Polshchak on 03.02.2022.
 * @project job4j_design
 */
public class SettingsTest {

    @Test
    public void whenClassLoader() throws Exception {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            settings.load(io);
        }
        String value = settings.getValue("hibernate.connection.username");
        assertThat(value, is("postgres"));
    }

}