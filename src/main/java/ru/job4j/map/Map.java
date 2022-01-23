package ru.job4j.map;

/**
 * @author Artem Polshchak on 17.01.2022.
 * @project job4j_design 8. Реализовать собственную структуру данных - HashMap [#1008]
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.5. Map
 */
public interface Map<K, V> extends Iterable<K> {
    boolean put(K key, V value);
    V get(K key);
    boolean remove(K key);
    int size();

}
