package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Polshchak on 29.01.2022.
 * @project job4j_design
 * 0.4. BufferedOutputStream [#252490]010
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] tmp = line.split(" ");
                for (int i = 0; i < tmp.length; i++) {
                    if (tmp[tmp.length - 2].contains("404")) {
                        result.add(line);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void save(List<String> log, String file) {

            try (PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(file)

            ))) {
                for (String s : log) {
                    out.println(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}
