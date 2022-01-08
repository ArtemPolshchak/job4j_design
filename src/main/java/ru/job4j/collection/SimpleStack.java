package ru.job4j.collection;

/**
 * @author Artem Polshchak on 07.01.2022.
 * @project job4j_design 4. Используя контейнер на базе связанного списка создать контейнер Stack [#71474]112
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.3. List
 */
public class SimpleStack<T> {
    final private ForwardLinked<T> linked = new ForwardLinked<>();

    /**
     * Метод возвращает значение и удаляет его из коллекции
     * @return удаленный элемент
     */
    public T pop() {
        return linked.deleteFirst();
    }

    /**
     * Метод помещает значение в коллекцию
     * @param value помещенное значение
     */
    public void push(T value) {
        linked.addFirst(value);

    }

    /**
     * Метод проверяет пустой ли лист или нет
     *
     * @return {@code true} если лист пустой, {@code false} если лист не пустой
     */
    public boolean isEmpty() {
        return linked.isEmpty();
    }
}
