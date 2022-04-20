package ru.job4j.searchfiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author artem.polschak@gmail.com on 19.04.2022.
 * @project job4j_design
 * 2. Поиск файлов по критерию [#783]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.5. Контрольные вопросы
 */
public class Find  {

    public static void main(String[] args) throws IOException {
        ArgsNames argsName = ArgsNames.of(args);
        Path start = Paths.get(argsName.get("d"));

        validation(args, start);

        List<Path> pathList = new ArrayList<>(search(start, getCondition(argsName)));
        writeFile(pathList, argsName);
    }

    /**
     * Метод задает тип поиска файлов в дирректории
     * по имени, по маске, по регулярному выражению
     * @param argsName список аргументов
     * @return Predicate true
     */
    public static Predicate<Path> getCondition(ArgsNames argsName) {
        String type = argsName.get("t");
        Predicate<Path> result = path -> true;
        switch (type) {
            case "mask":
                String tmp = argsName.get("n");
                Pattern first = Pattern.compile("\\?");
                Matcher f = first.matcher(tmp);
                String tmp2 = f.replaceAll("\\\\w{1}");

                Pattern second = Pattern.compile("\\.");
                Matcher s = second.matcher(tmp2);
                String tmp3 = s.replaceAll("\\\\.");

                Pattern third = Pattern.compile("\\*");
                Matcher t = third.matcher(tmp3);
                String tmp4 = t.replaceAll(".*");
                result = path -> path.toFile().getName().matches(tmp4);
                break;
            case "name" :
                result = path -> path.toFile().getName().equals(argsName.get("n"));
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * Метод поиска файлов в дирректории по условию
     * @param root путь дирректории
     */
    public static List<Path> search(Path root, Predicate<Path> condition) {
        SearchFile searcher = new SearchFile(condition);
        try {
            Files.walkFileTree(root, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searcher.getPaths();
    }

    /**
     * Метод записывает результат поиска в файл log
     * @param pathList список с результатом поска
     * @param argsName аргумент -o, с именем файла для записи результата поиска
     */
  private static void writeFile(List<Path> pathList, ArgsNames argsName) {
        try (Writer out = new BufferedWriter(new FileWriter(argsName.get("o")))) {
            for (Path path : pathList) {
                out.write((path) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
  }

    /**
     * валидация аргументов
     * @param arg аргументы для проверки
     * @param start путь к дирректории
     */
    private static void validation(String[] arg, Path start) {
        if (arg.length != 4) {
            throw new IllegalArgumentException("make sure the ROOT folder has exactly four arguments.");
        }

        if (!start.toFile().isDirectory()) {
            throw new IllegalArgumentException("There is not such directory");
        }
    }
}
