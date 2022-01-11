package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.*;

/**
 * @author Artem Polshchak on 11.01.2022.
 * @project job4j_design
 * 1. Реализовать коллекцию Set на массиве [#996]09
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.4. Set
 */
public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>();

    /**
     * Метод добавляет новое уникальное значение в коллекцию,
     * @param value добавляемое значение
     * @return true если добавляемый в коллекцию элемент уникальный,
     */
    @Override
    public boolean add(T value) {
        boolean res = !contains(value);
        if (res) {
            set.add(value);
        }
        return res;
    }

    /**
     * Метод сравнивает содержит ли коллекция данный елемент
     * если данный елемент присутствует в коллекции, метод возвращает true
     * @param value елемент,по которому осуществляется сравнение с коллекцией
     * @return true если елемент value есть в коллекции
     */
    @Override
    public boolean contains(T value) {
        boolean res = false;
        for (T object : set) {
            if (Objects.equals(value, object)) {
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     * Метод осуществляет перебор коллекции
     * @return список елементов присутствующих в коллекции
     */
    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
