package ru.job4j.generic;

/**
 * @author Artem Polshchak on 28.12.2021.
 * @project job4j_design
 * Job4j
 * Уроки
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base>
 */

public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
