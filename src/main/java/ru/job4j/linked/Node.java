package ru.job4j.linked;

public final class Node<T> {

    private final Node<T> next;
    private final T value;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }
}
