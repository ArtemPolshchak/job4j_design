package ru.job4j.io;



import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Artem.polschak@gmail.com on 12.02.2022.
 * @project job4j_design
 * 5.2. Архивировать проект [#861]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */
public class Zip {

    /**
     * Метод упаковывает файлы в Zip архив
     * @param sources коллекция файлов, которые будут упаковываться
     * @param target файл в который будет упаковываться коллекция sources
     */
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Метод поиска дубликатов
     * @param path путь к директории для поиска дубликатов
     * @param fileExtension обозначение расширения файла. Файлы с данным расширением нужно исключить из поиска
     * @return list
     */
    public static List<File> searcherFile(Path path, String fileExtension) {
        List<Path> list = new ArrayList<>();
        try {
            list = Search.search(path, s -> !s.toFile().getName().endsWith(fileExtension));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.stream().map(Path::toFile).collect(Collectors.toList());
    }



    public static void main(String[] args) {

        ArgsName argsName = ArgsName.of(args);
        Path start = Paths.get(argsName.get("d"));

        if (args.length != 3) {
            throw new IllegalArgumentException("make sure the ROOT folder has exactly three arguments.");
        }
        if (!argsName.get("e").startsWith(".")) {
            throw new IllegalArgumentException("the argument is not the file extension");
        }
        if (!start.toFile().isDirectory()) {
            throw new IllegalArgumentException("There is not such directory");
        }

        new Zip().packFiles(searcherFile(start, argsName.get("e")), new File(argsName.get("o")));

    }
}
