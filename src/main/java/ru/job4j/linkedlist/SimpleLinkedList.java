package ru.job4j.linkedlist;

import java.util.*;

/**
 * @author Artem Polshchak on 07.01.2022.
 * @project job4j_design
 * 2. Создать контейнер на базе связанного списка [#159]013
 * Уровень : 2. ДжуниорКатегория : 2.1.
 * Структуры данных и алгоритмы.Топик : 2.1.3. List
 */

public class SimpleLinkedList<E> implements List<E> {
    private int size = 0;
    private int modCount;
    private Node<E> first;
    private Node<E> last;

   private class Node<E> {
         private final E element;
         private Node<E> next;
         public Node(E element) {
             this.element = element;
         }
   }

    /**
     * Метод добавляет елемент в конец списка.
     *
     * @param value елемент, который додается.
     */

    @Override
    public void add(E value) {
       Node<E> newNode = new Node<>(value);
       if (first == null) {
           first = newNode;
           last = newNode;
       } else {
           last.next = newNode;
            last = newNode;
       }
        size++;
       modCount++;
    }

    @Override
    public int size() {
        return size;
    }

    private Node<E> getNodeByIndex(int index) {
       Objects.checkIndex(index, size);
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Метод извлекает элементы по индексу их позиции.
     * В случае, если указанный индекс вне списка, ограничивает его ->
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index елемент индекс
     * @return елемент листа
     */
    @Override
    public E get(int index) {
        return getNodeByIndex(index).element;
    }


    /**
     * Метод осуществляет перебор елементов массива
     * @return элемент листа.
     */
    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            final int expectModCount = modCount;
            Node<E> current = first;

            @Override
            public boolean hasNext() {
                if (modCount != expectModCount) {
                    throw new ConcurrentModificationException();
                }
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
