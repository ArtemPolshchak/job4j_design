package ru.job4j.tree;

import java.util.*;

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
     * Метод производит поиско в дереве по элементу value
     * @param value элемент, по которому производится поиск
     * @return value если данный элемент присутствует в дереве, в противном случае возвращает null
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
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
