package ru.job4j.set;

/**
 * @author Artem Polshchak on 11.01.2022.
 * @project job4j_design
 * 1. Реализовать коллекцию Set на массиве [#996]09
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.4. Set
 */
public interface Set<T> extends Iterable<T> {
    boolean add(T value);
    boolean contains(T value);
}
