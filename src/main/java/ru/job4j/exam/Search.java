package ru.job4j.exam;

import ru.job4j.searchfiles.SearchFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Artem Polshchak on 06.02.2022.
 * @project job4j_design
 */

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("make sure the ROOT folder has exactly two arguments.");
        }

        Path start = Paths.get(args[0]);

        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException("the argument is not the file extension");
        }

        if (!start.toFile().isDirectory()) {
            throw new IllegalArgumentException("There is not such directory");
        }

        search(start, path -> path.toFile().getName().endsWith(".txt")).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFile searcher = new SearchFile(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}