package ru.job4j.question;

import org.junit.Test;

import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Artem Polshchak on 24.01.2022.
 * @project job4j_design 2. Статистика по коллекции. [#45889]
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.7. Контрольные вопросы
 */
public class AnalysisTest {
    @Test
    public void whenNotChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u2, u3);
        assertThat(Analysis.diff(previous, current), is(new Info(0, 0, 0)));
    }

    @Test
    public void whenOneChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, new User(2, "BB"), u3);
        assertThat(
                Analysis.diff(previous, current),
                is(new Info(0, 1, 0))
        );
    }

    @Test
    public void whenTwoChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, new User(2, "BB"), new User(3, "lll"));
        assertThat(
                Analysis.diff(previous, current),
                is(new Info(0, 2, 0))
        );
    }

    @Test
    public void whenOneDeleted() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u3);
        assertThat(
                Analysis.diff(previous, current),
                is(new Info(0, 0, 1))
        );
    }

    @Test
    public void whenTwoDeleted() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        User u4 = new User(4, "D");
        Set<User> previous = Set.of(u1, u2, u3, u4);
        Set<User> current = Set.of(u1, u3);
        assertThat(
                Analysis.diff(previous, current),
                is(new Info(0, 0, 2))
        );
    }

    @Test
    public void whenOneAdded() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u2, u3, new User(4, "D"));
        assertThat(
                Analysis.diff(previous, current),
                is(new Info(1, 0, 0))
        );
    }

    @Test
    public void whenTwoAdded() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u2, u3, new User(4, "D"), new User(5, "E"));
        assertThat(
                Analysis.diff(previous, current),
                is(new Info(2, 0, 0))
        );
    }

    @Test
    public void whenAllChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(new User(1, "AA"), u2, new User(4, "D"), new User(5, "L"));
        assertThat(
                Analysis.diff(previous, current),
                is(new Info(2, 1, 1))
        );
    }

}