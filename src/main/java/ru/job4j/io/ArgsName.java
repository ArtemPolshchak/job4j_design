package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author Artem.polschak@gmail.com on 12.02.2022.
 * @project job4j_design
 * 5.1. Именованные аргументы [#295518]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */
public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("There is not arguments");
        }

        for (String arg : args) {
            if (!arg.contains("encoding=")) {
                String[] list = arg.split("=", 2);
                if (list[1].equals("")) {
                    throw new IllegalArgumentException("there is incorrect value of key");
                } else {
                    String key = list[0].substring(1);
                    values.put(key, list[1]);
                }
            }
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
