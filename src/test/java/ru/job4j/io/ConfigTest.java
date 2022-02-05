package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Artem Polshchak on 03.02.2022.
 * @project job4j_design
 * 1. Читаем файл конфигурации [#858]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */
public class ConfigTest {

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
    public void whenPairWithEmptyLines() {
        String path = "./data/pair_with_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        String str = config.toString();
        assertThat(str, is("fileName=www.coll\r\nname=Petr "
                + "Arsentev\r\nPathName=d.call.to\r\nsecondName=Vitas"));
    }
}