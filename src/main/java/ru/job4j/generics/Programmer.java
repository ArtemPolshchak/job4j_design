package ru.job4j.generics;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @author Artem Polshchak on 23.12.2021.
 * @project job4j_design 0. Что такое обобщенные типы (generics) [#4952]
 */
public class Programmer extends Person {
    public Programmer(String name, int age, Date birthday) {
        super(name, age, birthday);
    }

    public void printInfo(Collection<Person> col) {
        for (Iterator<Person> it = col.iterator(); it.hasNext();) {
            Person next = it.next();
            System.out.println(next);
        }
    }

}
