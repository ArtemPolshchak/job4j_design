package ru.job4j.exam;

import ru.job4j.searchfiles.ArgsNames;

import java.io.*;
import java.util.*;

/**
 * @author Artem.polschak@gmail.com on 15.03.2022.
 * @project job4j_design
 * 7. Scanner [#504791]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */
public class Reader {
    private static String path = "path";
    private static String out = "out";
    private static String delimiter = "delimiter";
    private static String filter = "filter";
    private static String stdout = "stdout";

    private static void validation(File file, File target, ArgsNames argsName) {
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }

        if (!stdout.equals(argsName.get(out))) {
            if (!target.exists()) {
                throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
            }
        }
    }

    public static void handle(ArgsNames argsName)  {
        List<String> resultList = new ArrayList<>();
        File fileIn = new File(argsName.get(path));
        File fileOut = new File(argsName.get(out));

        validation(fileIn, fileOut, argsName);

        String[] filterArguments = argsName.get(filter).split(",");

        try (Scanner scanner = new Scanner(
                new BufferedInputStream(
                        new FileInputStream(fileIn))).useDelimiter(System.getProperty("line.separator"))) {

            List<Integer> numList = new ArrayList<>();
            while (scanner.hasNext()) {
                String str = scanner.next();
                String[] tmp = str.split(argsName.get(delimiter));
                for (String s : filterArguments) {
                    for (int l = 0; l < tmp.length; l++) {
                        if (tmp[l].equals(s)) {
                            numList.add(l);
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (Integer s : numList) {
                    stringBuilder.append(tmp[s]).append(argsName.get(delimiter));
                }
                String s = stringBuilder.substring(0, stringBuilder.length() - 1);
                resultList.add(s);
            }
            if (stdout.equals(argsName.get(out))) {
                for (String s : resultList) {
                    System.out.println(s);
                }
            } else {
                try (FileWriter writer = new FileWriter(fileOut)) {
                    for (String s : resultList) {
                        writer.write(s + System.getProperty("line.separator"));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsNames argsName = ArgsNames.of(args);
        handle(argsName);
    }
}