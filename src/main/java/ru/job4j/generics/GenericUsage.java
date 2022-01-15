package ru.job4j.generics;

import java.util.*;

/**
 * @author Artem Polshchak on 23.12.2021.
 * @project job4j_design 0. Что такое обобщенные типы (generics) [#4952]
 */
public class GenericUsage {
    public static void main(String[] args) {

        List<? super Integer> list = new ArrayList<>();
        new GenericUsage().addAll(list);

    }

    public void printRsl(Collection<?> col) {
        for (Iterator<?> it = col.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator(); it.hasNext();) {
            Person next = it.next();
            System.out.println(next);
        }
    }

    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
