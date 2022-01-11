package ru.job4j.linkedlist;

import java.util.ListIterator;

/**
 * @author Artem Polshchak on 07.01.2022.
 * @project job4j_design
 * 2. Создать контейнер на базе связанного списка [#159]013
 * Уровень : 2. ДжуниорКатегория : 2.1.
 * Структуры данных и алгоритмы.Топик : 2.1.3. List
 */

public interface List<E> extends Iterable<E> {
    void add(E value);
    E get(int index);
    int size();
}
