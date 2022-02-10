package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Artem Polshchak on 09.02.2022.
 * @project job4j_design 4.2. Поиск дубликатов [#315066]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */

public class DuplicatesFinder {

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Path.of("D:\\Новая Папка"), new DuplicatesVisitor());
    }
}
