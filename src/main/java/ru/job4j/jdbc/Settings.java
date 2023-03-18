package ru.job4j.jdbc;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Artem Polshchak on 03.02.2022.
 * @project job4j_design
 */
public class Settings {
    private final Properties prs = new Properties();

    public void load(InputStream io) {
        try {
            this.prs.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.prs.getProperty(key);
    }
}
