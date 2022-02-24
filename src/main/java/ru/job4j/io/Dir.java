package ru.job4j.io;

import java.io.File;

/**
 * @author Artem Polshchak on 06.02.2022.
 * @project job4j_design
 * 4.0. File [#252491]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */
public class Dir {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {
            System.out.println(subfile.getName() + " " + subfile.length());
        }
    }
}
