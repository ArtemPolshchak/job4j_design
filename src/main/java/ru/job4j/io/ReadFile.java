package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * @author Artem Polshchak on 29.01.2022.
 * @project job4j_design
 * 0.3. BufferedReader. [#252489]013
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */
public class ReadFile {
    /**
     * Метод читает данные с файла и выводит в консоль
     */
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            in.lines().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
