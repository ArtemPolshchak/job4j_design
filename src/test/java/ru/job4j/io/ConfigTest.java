package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;



/**
 * @author Artem Polshchak on 03.02.2022.
 * @project job4j_design
 * 1. Читаем файл конфигурации [#858]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */
public class ConfigTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairThroughIllegalArgException() {
        String path = "./data/pair_with_IllegalArgException.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertFalse(config.toString().contains("# PostgreSQL"));

    }

    @Test
    public void whenIgnoreEmptyLines() throws IOException {
        File source = folder.newFile("pair_with_empty_lines.properties");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println(" ");
            out.println("name=Petr Arsentev");
            out.println(" ");
            out.println("PathName=d.call.to");
        }
        Config config = new Config(source.getPath());
        config.load();

        assertThat(config.toString(), is("name=Petr Arsentev\r\nPathName=d.call.to"));
    }
}