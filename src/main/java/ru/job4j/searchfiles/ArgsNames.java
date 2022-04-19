package ru.job4j.searchfiles;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Artem.polschak@gmail.com on 12.02.2022.
 * @project job4j_design
 */
public class ArgsNames {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("There is not arguments");
        }

        for (String arg : args) {
            String[] list = arg.split("=", 2);
            if (list[1].equals("")) {
                throw new IllegalArgumentException("there is incorrect value of key");
            } else {
                if (!list[0].startsWith("-")) {
                    throw new IllegalArgumentException("incorrect key");
                }
                String key = list[0].substring(1);
                values.put(key, list[1]);
            }
        }
    }

    public static ArgsNames of(String[] args) {
        ArgsNames names = new ArgsNames();
        names.parse(args);
        return names;
    }
}