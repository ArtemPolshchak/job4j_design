package ru.job4j.io;

import java.io.*;
import java.util.*;

/**
 * @author Artem.polschak@gmail.com on 15.03.2022.
 * @project job4j_design
 * 7. Scanner [#504791]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */
public class CSVReader {
    static String path = "path";
    static String out = "out";
    static String delimiter = "delimiter";
    static String filter = "filter";

    private static void validation(File file, File target) {
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }

        if (!target.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
    }

    public static void handle(ArgsName argsName)  {
        List<String> resultList = new ArrayList<>();
        File fileIn = new File(argsName.get(path));
        File fileOut = new File(argsName.get(out));

        validation(fileIn, fileOut);

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
                        if (s.equals(tmp[l])) {
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

            try (FileWriter writer = new FileWriter(fileOut)) {
                for (String s : resultList) {
                    writer.write(s + System.getProperty("line.separator"));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
