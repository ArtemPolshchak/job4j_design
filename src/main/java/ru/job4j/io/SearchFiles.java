package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * @author Artem Polshchak on 06.02.2022.
 * @project job4j_design
 * 4.1. Сканирование файловой системы. [#106929]0
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */

public class SearchFiles extends SimpleFileVisitor<Path> {
    Predicate<Path> predicate;
    List<Path> list = new ArrayList<>();

    public SearchFiles(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    public List<Path> getPaths() {
        return list;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
       if (predicate.test(file)) {
           list.add(file);
       }
        return CONTINUE;
    }
}