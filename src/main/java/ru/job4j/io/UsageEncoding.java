package ru.job4j.io;



import java.io.*;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/**
 * @author Artem.polschak@gmail.com on 12.02.2022.
 * @project job4j_design
 * 6. Кодировка. [#862]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */

public class UsageEncoding {
    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.lines().forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void writeDataInFile(String path, List<String> data) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            data.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String path = "./src/text.txt";
        UsageEncoding encoding = new UsageEncoding();
        List<String> strings = List.of(
                "Новая строка 1",
                "Новая строка 2",
                "Новая строка 3",
                "Новая строка 4",
                "Новая строка 5"
        );

            encoding.writeDataInFile(path, strings);

        String s = encoding.readFile(path);
        System.out.println("Данные из файла: ");
        System.out.println(s);
    }
}
