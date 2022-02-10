package ru.job4j.io.duplicates;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * @author Artem Polshchak on 09.02.2022.
 * @project job4j_design 4.2. Поиск дубликатов [#315066]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */

public class DuplicateVisitor extends SimpleFileVisitor<Path> {

    private final HashSet<FileProperty> set = new HashSet<>();
    private final List<FileProperty> duplicate = new ArrayList<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());

         if (set.contains(fileProperty)) {

                duplicate.add(fileProperty);
                for (FileProperty s : set) {
                    if (s.equals(fileProperty)) {
                        duplicate.add(s);
                    }
                }
                set.remove(fileProperty);

        } else if (!set.contains(fileProperty)) {
            if (!duplicate.contains(fileProperty)) {
                set.add(fileProperty);
            } else {
                duplicate.add(fileProperty);
            }

        }
        return CONTINUE;
    }

    public void getDuplicate() {

        for (FileProperty fileProperty : duplicate) {
            File file = new File(fileProperty.toString());
            System.out.println(file.getAbsolutePath());
        }
    }
}