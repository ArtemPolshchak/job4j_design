package ru.job4j.question;

import java.util.*;

/**
 * @author Artem Polshchak on 24.01.2022.
 * @project job4j_design 2. Статистика по коллекции. [#45889]
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.7. Контрольные вопросы
 */
public class Analysis {

    public static Info diff(Set<User> previous, Set<User> current) {
        int add = 0;
        int change = 0;
        int delete = 0;
        int count = 0;
        Info info = new Info(add, change, delete);

        Map<Integer, String> map = new LinkedHashMap<>();
        for (User user : previous) {
            map.put(user.getId(), user.getName());
        }
        for (User user : current) {
                if (!map.containsKey(user.getId())) {
                    info.setAdded(++add);
                    count++;
                } else if (map.containsKey(user.getId())) {
                        if (!map.containsValue(user.getName())) {
                            info.setChanged(++change);
                        }
                }
        }
        delete = previous.size() - (current.size() - count);
        info.setDeleted(delete);

        return info;
    }
}
