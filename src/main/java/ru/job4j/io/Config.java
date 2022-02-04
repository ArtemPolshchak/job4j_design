package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Artem Polshchak on 03.02.2022.
 * @project job4j_design
 * 1. Читаем файл конфигурации [#858]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */
public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * Метод добавляет инфорвацию с файла .properties в config -> key, value
     * метод игнорирует комментарии
     * метод игнорирует пустые строки
     */
    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                String str = reader.readLine();
                if (!str.isEmpty() && !str.contains("#") && str.contains("=")) {
                    String[] strings = str.split("=");
                    if (strings[0].isEmpty() || strings[1].isEmpty()) {
                        throw new IllegalArgumentException();
                    }
                    values.put(strings[0], strings[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Метод производит поиск значения в config  по ключу
     * @param key ключ, по которому осуществляется поиск
     * @return entry.getValue()
     */
    public String value(String key) {
        String res = "";
        if (values.containsKey(key)) {
            for (Map.Entry<String, String> entry : values.entrySet()) {
                if (entry.getKey().equals(key)) {
                    res =  entry.getValue();
                }
            }
        } else {
            return null;
        }
        return res;
    }

    /**
     * Переопределенный метод, выводит на экран содержимоее config
     * @return StringJoiner out
     */
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        for (Map.Entry<String, String> entry : values.entrySet()) {
            out.add(entry.getKey() + "=" + entry.getValue());
        }
        return out.toString();
    }
}
