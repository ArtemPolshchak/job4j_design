package ru.job4j.map;

import java.util.*;

/**
 * @author Artem Polshchak on 12.01.2022.
 * @project job4j_design 1. Создать модель User [#999]
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.5. Map
 */
public class User {
    /*private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2000, Calendar.JANUARY, 25);
        User user = new User("Bob", 1, calendar);
        User user2 = new User("Bob", 1, calendar);
        User user3 = new User("Bob", 1, calendar);

        Map<User, Object> map = new HashMap<>();
        map.put(user, new Object());
        map.put(user2, new Object());
        map.put(user3, new Object());

        for (Map.Entry<User, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());
        System.out.println();

        boolean res = (user.hashCode() == user2.hashCode());
        System.out.println(res);
    }*/

}
