package ru.job4j.io;

import java.io.*;

/**
 * @author Artem Polshchak on 04.02.2022.
 * @project job4j_design
 * 2. Анализ доступности сервера. [#859]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */

public class Analysis {
    /**
     * Метод находит диапазоны, когда сервер не работает
     * @param source файл источник информации с логами
     * @param target файл, куда записывается информация
     */
    public void unavailable(String source, String target) {
        boolean workServer = true;
        String result = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
                while (reader.ready()) {
                    String status = reader.readLine();
                    if (status.startsWith("400") || status.startsWith("500")) {
                        if (workServer) {
                            String[] line = status.split(" ");
                            result = line[1];
                            workServer = false;
                        }
                    } else if (!workServer) {
                        if (!status.startsWith("400") || !status.startsWith("500")) {
                            String[] line = status.split(" ");
                            String resString = result + ";" + line[1];
                            writer.println(resString);
                            workServer = true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis  analysis = new Analysis();
        analysis.unavailable("server.txt", "target.txt");
    }
}
