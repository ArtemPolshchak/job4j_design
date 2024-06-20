package ru.job4j.generics;

/**
 * @author Artem Polshchak on 23.12.2021.
 * @project job4j_design 0. Что такое обобщенные типы (generics) [#4952]
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
}
