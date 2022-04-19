package ru.job4j.searchfiles;

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
 */

public class SearchFile implements FileVisitor<Path> {
    private final Predicate<Path> condition;
    private final List<Path> collector;

    public SearchFile(Predicate<Path> condition) {
        this.condition = condition;
        collector = new ArrayList<>();
    }

    public List<Path> getPaths() {
        return collector;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (condition.test(file)) {
            collector.add(file);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return CONTINUE;
    }
}