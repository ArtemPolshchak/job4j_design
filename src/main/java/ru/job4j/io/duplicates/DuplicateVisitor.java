package ru.job4j.io.duplicates;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * @author Artem Polshchak on 09.02.2022.
 * @project job4j_design 4.2. Поиск дубликатов [#315066]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */

public class DuplicateVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, List<Path>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
        Path path = Paths.get(file.toFile().getAbsolutePath());

         if (map.containsKey(fileProperty)) {
             for (Map.Entry<FileProperty, List<Path>> listEntry : map.entrySet()) {
                 if (listEntry.getKey().equals(fileProperty)) {
                     List<Path> list = listEntry.getValue();
                     list.add(path);
                     listEntry.setValue(list);
                 }
             }

         } else {
             ArrayList<Path> list = new ArrayList<>();
             list.add(path);
             map.put(fileProperty, list);
         }
        return CONTINUE;
    }

    public void getDuplicate() {

        for (Map.Entry<FileProperty, List<Path>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                int number = 0;
                while (number < entry.getValue().size()) {
                    System.out.println("Дубликат: " + entry.getValue().get(number++));
                }
            }
        }
    }
}