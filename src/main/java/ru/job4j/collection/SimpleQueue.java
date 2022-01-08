package ru.job4j.collection;


/**
 * @author Artem Polshchak on 08.01.2022.
 * @project job4j_design 5. Очередь на двух стеках [#160]112
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.3. List
 */

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    /**
     * Метод возвращает первое значение и удаляет его из коллекции
     * @return element
     */
    public T poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Метод помещает значение в конец коллекции
     * @param value значение
     */
    public void push(T value) {
        in.push(value);
    }
}
