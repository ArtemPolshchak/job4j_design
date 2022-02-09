package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Artem Polshchak on 06.02.2022.
 * @project job4j_design
 * 4.1. Сканирование файловой системы. [#106929]0
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get("D:\\testForJob4j");
        search(start, path -> path.toFile().getName().endsWith(".xml")).forEach(System.out::println);

    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
