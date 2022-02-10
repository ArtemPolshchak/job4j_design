package ru.job4j.io.duplicates;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * @author Artem Polshchak on 09.02.2022.
 * @project job4j_design 4.2. Поиск дубликатов [#315066]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */

class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final HashSet<FileProperty> set = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (set.contains(fileProperty)) {
            System.out.println("Дубликат " + file);
        } else {
            set.add(fileProperty);
        }
        return CONTINUE;
    }
}