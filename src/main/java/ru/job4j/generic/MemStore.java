package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Artem Polshchak on 28.12.2021.
 * @project job4j_design
 * Job4j
 * Уроки
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base>
 */

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        storage.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {

        return storage.replace(id, storage.get(id), model);
    }

    @Override
    public boolean delete(String id) {
       return storage.keySet().remove(id);
    }

    @Override
    public T findById(String id) {
        return storage.get(id);
    }
}
