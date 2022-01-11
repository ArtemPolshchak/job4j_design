package ru.job4j.iterator;

import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.*;
import static org.junit.Assert.assertThat;

/**
 * @author Artem Polshchak on 09.01.2022.
 * @project job4j_design
 * 7. ListIterator [#350217]015
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.3. List
 */

public class ListUtilsTest {

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        int index = 5;
        int value = 100;
        ListUtils.replaceIf(input, x -> x.equals(index), value);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3, 4, 100, 6, 7, 8, 9)));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int del = input.get(4);
        ListUtils.removeIf(input, x -> x.equals(del));
        assertThat(input, is(Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9)));
    }

    @Test
    public void whenRemoveSomeEl() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        ListUtils.removeAll(input, elements);
        assertThat(input, is(Arrays.asList(2, 4, 6, 8, 9)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        ListUtils.removeAll(input, elements);
        assertThat(input, is(Collections.emptyList()));
    }

    @Test
    public void whenAddFirstElement() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6));
        ListUtils.addBefore(input, 0, 1);

        assertThat(input, is(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6));
        ListUtils.addBefore(input, 3, 4);

        assertThat(input, is(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 5, 6));
        ListUtils.addAfter(input, 3, 4);

        assertThat(input, is(Arrays.asList(0, 1, 2, 3, 4, 5, 6)));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 3, 2);
    }

}