package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author Artem Polshchak on 09.01.2022.
 * @project job4j_design
 * 7. ListIterator [#350217]015
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.3. List
 */

public class ListUtils {

    /**
     * Метод добавляет новый елемент в коллекцию перед указанным индексом
     * @param list колекция, в которую осуществляется вставка
     * @param index индекс, перед которым осуществляется вставка
     * @param value значение, которое вставляется в коллекцию
     * @param <T> тип объектов
     */
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator  = list.listIterator(index);
        iterator.add(value);

    }

    /**
     * Метод добавляет новый елемент в коллекцию после указанного  индекса
     * @param list колекция, в которую осуществляется вставка
     * @param index индекс, после которого осуществляется вставка
     * @param value значение, которое вставляется в коллекцию
     * @param <T> тип объектов
     */
    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index + 1, list.size());
        ListIterator<T> iterator  = list.listIterator(index + 1);
                iterator.add(value);

    }

    /**
     * Метод удаляет элемент из коллекции если он соответствует предикату
     * @param list коллекция из которой удаляется элемент
     * @param filter предикат, задает условие, которому должен соответствовать удаляемый элемент
     * @param <T> тип объектов
     */
    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> iterator = list.listIterator();

        while (iterator.hasNext()) {
            if (filter.test(iterator.next())) {
                iterator.remove();
                break;
            }
        }
    }

    /**
     * Метод заменяет текущий элемент коллекции по предикату  на новый элемент
     * @param list коллекция в которой осуществляется замена элемента
     * @param filter предикат, задает условие, которому должен соответствовать удаляемый элемент
     * @param value значение, которое вставляется в коллекцыю взамен удаляемого значения
     * @param <T> тип объектов
     */
    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> iterator = list.listIterator();

        while (iterator.hasNext()) {
            if (filter.test(iterator.next())) {
                iterator.set(value);
                break;
            }
        }
    }

    /**
     * Метод удаляет из коллекции list все элементы, которые совпадают с элементами из коллекции elements
     * @param list коллекция из которой осуществляется удаление элементов
     * @param elements коллекция, с элементами, которые необходимо удалить из коллекции list
     * @param <T> тип объектов
     */
    public static <T> void removeAll(List<T> list, List<T> elements) {
        for (T element : elements) {
            removeIf(list, x -> x.equals(element));
        }
    }
}
