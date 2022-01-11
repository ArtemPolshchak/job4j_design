package ru.job4j.set;


import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Artem Polshchak on 11.01.2022.
 * @project job4j_design
 * 1. Реализовать коллекцию Set на массиве [#996]09
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.4. Set
 */
public class SimpleSetTest {

    @Test
    public void testAddWithNull() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(null);
        set.add(2);
        set.add(4);
        set.add(null);
        set.add(4);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is((Integer) null));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(3));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenNextNull() {
        SimpleSet<Integer> set = new SimpleSet<>();
        Iterator<Integer> iterator = set.iterator();
        iterator.next();
    }

    @Test
    public void whenAdd() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));

    }

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(5));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddWithNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.add(2));
        assertTrue(set.contains(null));
        assertTrue(set.contains(2));
        assertFalse(set.add(null));
        assertFalse(set.add(2));
    }

}