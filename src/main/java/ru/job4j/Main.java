package ru.job4j;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.HashMap;

/**
 * @author User on 11.01.2022.
 * @project job4j_design
 */
public class Main {
    public static void main(String[] args) {
     /*   int a = 16;
        System.out.println(hash(a));
        System.out.println(binary(a));

*/

    }

  /*  static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }*/

    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

}
