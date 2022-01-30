package ru.job4j.io;

import java.io.FileInputStream;

/**
 * @author Artem Polshchak on 29.01.2022.
 * @project job4j_design
 * 0.2. FileInputStream [#4898]010
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                boolean res = Integer.parseInt(line) % 2 == 0;
                if (res) {
                    System.out.println("число " + line + " является четным");
                } else {
                    System.out.println("число " + line + " является нечетным");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
