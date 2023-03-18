package ru.job4j.exam;

import ru.job4j.searchfiles.ArgsNames;
import ru.job4j.searchfiles.SearchFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author artem.polschak@gmail.com on 05.04.2022.
 * @project job4j_design
 * 2. Поиск файлов по критерию [#783]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.5. Контрольные вопросы
 *
 */
public class Main  {
    public static void main(String[] args) throws IOException {
        String[] arg = new String[] {"-d=d:/", "-n=1.txt", "-t=mask", "-o=log.txt"};
        ArgsNames argsName = ArgsNames.of(arg);
        Path start = Paths.get(argsName.get("d"));

       // Search.search(start, path -> path.toFile().getName().contains(argsName.get("n"))).forEach(System.out::println);

        /*Можно чуть проще: path.toString().matches(pattern), где pattern - просто параметр командной строки*/

        List<File> fileList = new ArrayList<>();
        searchFiles(new File(argsName.get("d")), fileList);

            writeFile(fileList, argsName);
        search(start, path -> path.toFile().getName().endsWith(".txt")).forEach(System.out::println);

    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFile searcher = new SearchFile(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }



    private static void searchFiles(File rootFile, List<File> fileList) {
        if (!rootFile.isDirectory()) {
            System.out.println("нет такой папки");
        }
        File[] directoryFiles = rootFile.listFiles();
        if (directoryFiles != null) {
            for (File file : directoryFiles) {
                if (!file.isDirectory()) {
                    if (file.getName().toLowerCase().endsWith(".txt")) {
                        fileList.add(file);
                    }

                } else {
                    searchFiles(file, fileList);
                }
            }
        }
    }

    public static void writeFile(List<File> paths, ArgsNames argsName) {
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(argsName.get("o"))))) {
            for (File path : paths) {
                out.write(String.valueOf(path) + "\n");
                //out.write("\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
