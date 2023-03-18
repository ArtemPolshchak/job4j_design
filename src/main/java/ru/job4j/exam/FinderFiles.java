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
import java.util.regex.Pattern;

/**
 * @author User on 19.04.2022.
 * @project job4j_design
 */
public class FinderFiles {
    public static void main(String[] args) throws IOException {
        String[] arg = new String[] {"-d=d:/", "-n=.*/.txt", "-t=regex", "-o=log.txt"};
        ArgsNames argsName = ArgsNames.of(arg);
        Path start = Paths.get(argsName.get("d"));
        writeFile(pathList(start, argsName), argsName);
    }


    public static List<Path> pathList(Path root, ArgsNames argsName) throws IOException {
        List<Path> listPath = new ArrayList<>();
        String param = argsName.get("t");
        if ("mask".equals(param)) {
            listPath = search(root, s -> s.toFile().getName().endsWith(argsName.get("n")));
            for (Path path : listPath) {
                System.out.println(path.toString());
            }
        }
        if ("name".equals(param)) {
            listPath = search(root, s -> s.toFile().getName().equals(argsName.get("n")));
            for (Path path : listPath) {
                System.out.println(path.toString());
            }
        }

        if ("regex".equals(param)) {

            Pattern pattern = Pattern.compile(argsName.get("n"));
            listPath = search(root, s -> pattern.matcher(s.toFile().getName()).find());
            for (Path path : listPath) {
                System.out.println(path.toString());
            }
        }
        return listPath;
    }

    public static void writeFile(List<Path> pathList, ArgsNames argsName) {
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(argsName.get("o"))))) {
            for (Path path : pathList) {
                out.write(String.valueOf(path) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) {
        SearchFile searcher = new SearchFile(condition);
        try {
            Files.walkFileTree(root, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searcher.getPaths();
    }

}
