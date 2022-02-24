package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Artem Polshchak on 06.02.2022.
 * @project job4j_design
 * 3.0. Тестирование IO [#173905]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */
public class Abuse {
    public static void drop(String source, String target, List<String> words) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            in.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .filter(word -> !words.contains(word)).map(word -> word + " ")
                    .forEach(out::println);
        }

    }
}
