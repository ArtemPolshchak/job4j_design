package ru.job4j.map;

import java.util.Calendar;

/**
 * @author Artem Polshchak on 12.01.2022.
 * @project job4j_design 1. Создать модель User [#999]
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.5. Map
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
