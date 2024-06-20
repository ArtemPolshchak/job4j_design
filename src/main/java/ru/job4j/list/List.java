package ru.job4j.list;

/**
 * @author Artem Polshchak on 01.01.2022.
 * @project job4j_design
 * Уроки
 * 2.1.3. List
 * 1. Динамический список на массиве.
 */
public interface List<T> extends Iterable<T> {
    void add(T value);

    T set(int index, T newValue);

    T remove(int index);

    T get(int index);

    int size();
}
