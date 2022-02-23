package ru.job4j.io.scanner;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * @author Artem.polschak@gmail.com on 18.02.2022.
 * @project job4j_design
 * 7. Scanner [#504791]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */
public class ScannerExample2 {
    public static void main(String[] args) {
       var data = "empl1@mail.ru, eml2@mail.ru, eml3@mail.ru";
       var scanner = new Scanner(new ByteArrayInputStream(data.getBytes())).useDelimiter(", ");
       while (scanner.hasNext()) {
           System.out.println(scanner.next());
       }
    }
}
