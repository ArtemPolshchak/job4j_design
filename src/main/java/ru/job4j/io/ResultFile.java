package ru.job4j.io;

import java.io.FileOutputStream;

/**
 * @author Artem Polshchak on 29.01.2022.
 * @project job4j_design
 * 0.1. FileOutputStream. [#252488]012
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */
public class ResultFile {
    public static void main(String[] args) {
        int[][] table = new int[10][10];

        try (FileOutputStream out = new FileOutputStream("d:/1.txt")) {
            for (int row = 0; row < table.length; row++) {
                for (int cell = 0; cell < table[row].length; cell++) {
                    table[row][cell] = (row + 1) * (cell + 1);
                    String res = ((table[row][cell]) + " ");
                    out.write(res.getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
