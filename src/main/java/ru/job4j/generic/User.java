package ru.job4j.generic;

/**
 * @author Artem Polshchak on 28.12.2021.
 * @project job4j_design
 * Job4j
 * Уроки
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base>
 */

public class User extends Base {
    private final String userName;

    public User(String id, String name) {
        super(id);
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }
}
