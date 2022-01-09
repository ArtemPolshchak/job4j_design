package ru.job4j.collection;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Artem Polshchak on 07.01.2022.
 * @project job4j_design 3. Удалить head в односвязном списке. [#51424]112
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.3. List
 */
public class ForwardLinked<T>  implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int modCount = 0;
    private int size = 0;

    /**
     * Метод добавляет елемент в начало списка
     *
     * @param value елемент, который додается.
     */
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        modCount++;
        size++;
    }

    /**
     * Метод добавляет елемент в конец списка.
     *
     * @param value елемент, который додается.
     */
    public void add(T value) {
        modCount++;
        size++;
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;

    }

    /**
     * Метод удаляет Первый елемент листа
     * @return удаленный элемент
     */
    public T deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<T> deleteElement = head;
        head = head.next;
        deleteElement.next = null;
        size--;
        modCount++;
        return deleteElement.value;

    }

    /**
     * Метод проверяет пустой ли лист или нет
     *
     * @return {@code true} если лист пустой, {@code false} если лист не пустой
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Метод переставляет элементы в обратном порядке
     */
    public boolean revert() {
        if (isEmpty() || size() == 1) {
            return false;
        } else {
            if (head.next != null) {
                tail = head;
                Node<T> current = head.next;
                head.next = null;
                while (current != null) {
                    Node<T> tmp = current.next;
                    current.next = head;
                    head = current;
                    current = tmp;
                }
            }
            return true;
        }
    }

    /**
     * Метод возвращает размер списка
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Метод осуществляет перебор елементов массива
     * @return элемент листа.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            final int expectModCount = modCount;
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                if (modCount != expectModCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
