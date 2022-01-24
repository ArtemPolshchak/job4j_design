package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author Artem Polshchak on 24.01.2022.
 * @project job4j_design 1. Создать элементарную структуру дерева [#1711]07
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.6. Tree
 */

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    /**
     * Метод добавляет новый елемент в дерево
     * @param parent елемент родитель, к которому прикрепляется елемент children
     * @param child элемент потомок, который прикрепляется к элементу родителю
     * @return true если добавление выполнено успешно
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;

        Optional<Node<E>> optParent =  findBy(parent);
        Optional<Node<E>> optChildren =  findBy(child);
        if (optParent.isPresent()) {
            if (optChildren.isEmpty()) {
                Node<E> newChild = new Node<>(child);
                optParent.get().children.add(newChild);
                rsl = true;
            }
        }
        return rsl;

    }

    /**
     * Метод производит поиск элемента value в дереве.
     * @param value искомый элемент
     * @return value
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(e -> e.value.equals(value));
    }

    /**
     * Метод производит проверку, является ли дерево бинарным.
     * @return true если дерево бинароне.
     */
    @Override
    public boolean isBinary() {
     return findByPredicate(e -> e.children.size() > 2).isEmpty();

    }

    /**
     * Метод осуществляет перебр всех елементов дерева, и осуществления проверки Predicate condition
     * @param condition задает условие с проверкой true / false
     * @return возвращает rsl элемент соответствующий условию condition
     */
    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SimpleTree)) {
            return false;
        }
        SimpleTree<?> that = (SimpleTree<?>) o;
        return Objects.equals(root, that.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }
}
