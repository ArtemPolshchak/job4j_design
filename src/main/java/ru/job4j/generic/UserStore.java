package ru.job4j.generic;

/**
 * @author Artem Polshchak on 28.12.2021.
 * @project job4j_design
 * Job4j
 * Уроки
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base>
 */

public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        if (model != null) {
            store.add(new User(model.getId(), model.getUserName()));
        }
    }

    @Override
    public boolean replace(String id, User model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}
