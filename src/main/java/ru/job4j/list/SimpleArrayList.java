package ru.job4j.list;

import java.util.*;

/**
 * @author Artem Polshchak on 02.01.2022.
 * @project job4j_design
 * Уроки
 * 2.1.3. List
 * 1. Динамический список на массиве.
 */

public class SimpleArrayList<T> implements List<T> {

    /**
     * <container> массив
     */
    private T[] container;

    /**
     * <size> счетчик - указывающий на актуальный размер массива <container>
     */
    private int size;

    /**
     * <modCount> счетчик для определения общего количества структурных изменений, сделанных в этой коллекции
     * необходим для корректной работы <iterator>
     *
     */
    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    /**
     * Метод добавляет новый елемент <value> в <SimpleArrayList>
     * @param value значение добавляемое в <SimpleArrayList>
     */

    @Override
    public void add(T value) {
        increasingArray();
        container[size++] = value;
        modCount++;
    }

    /**
     * Метод проверяет если счетчик <size> ровняется размеру массива, или больше,
     * то массив увеличивается на 1 индекс
      */
    private void increasingArray() {
        if (size >= container.length) {
            container = Arrays.copyOf(container, container.length + 1);
        }
    }

    /**
     * Метод проверяет не вышел ли <index> за размер <container.length>
     * затем заменяет <oldValue> на  <newValue> по <index>
     * @param index индекс элемента, по которому нужно заменить значение
     * @param newValue новое значение, которое будет установлено по текущему <index>
     * @return <oldValue> значение, которое было удалено.
     */

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T oldValue = container[index];
        container[index] = newValue;
        modCount++;
        return oldValue;
    }

    /**
     * Метод проверяет не вышел ли <index> за размер <container.length>
     * затем удаляет <oldValue> по текущему <index>
     * @param index по которому удаляется значение
     * @return <oldValue> удаленное значение
     */

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T oldVaLue = container[index];
        int numContainer = size - index - 1;
         System.arraycopy(
                this.container, index + 1, this.container, index, numContainer
        );
        container[container.length - 1] = null;

         System.arraycopy(container, 0, container, 0, --size);
        modCount++;
        return oldVaLue;
    }

    /**
     * Метод проверяет не вышел ли <index> за размер <container.length>
     * затем возвращает значение по <index>
     * @param index индекс значения, которое требуется получить
     * @return значение, которое находится по <index>
     */

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    /**
     * Метод возвращает размер массива
     * @return <size>
     */

    @Override
    public int size() {
        return size;
    }

    /**
     * Метод осуществляет перебор елементов массива
     * @return container[cursor++]
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final int expectModCount = modCount;
            int cursor = 0;

            @Override
            public boolean hasNext() {
                if (modCount != expectModCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor < size;
            }
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[cursor++];
            }
        };
    }
}