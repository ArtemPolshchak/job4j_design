package ru.job4j.map;

import org.junit.Test;
import org.junit.Assert;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;

/**
 * @author Artem Polshchak on 17.01.2022.
 * @project job4j_design 8. Реализовать собственную структуру данных - HashMap [#1008]
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.5. Map
 */
public class SimpleMapTest {

    @Test
    public void putKeyDoubleTimeAndSizeDontChange() {
        Map<Integer, Integer> map = new SimpleMap<>();

        map.put(0, 10);
        map.put(2, 10);
        map.put(2, 12);
        Assert.assertEquals(2, map.size());
    }

    @Test
    public void putOneElement() {
        Map<String, Integer> map = new SimpleMap<>();

        map.put("", 10);

        Assert.assertEquals(1, map.size());
    }

    @Test
    public void getValueFromKey() {
        Map<Integer, Integer> map = new SimpleMap<>();
        map.put(0, 10);
        map.put(2, 21);
        int res = map.get(2);
        Assert.assertThat(res, is(21));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmpty() {
        Map<Integer, String> map = new SimpleMap<>();
        map.get(2);
    }

    @Test
    public void getElementByKey() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(0, "lol");
        map.put(2, "haha");
        String res = map.get(0);
        Assert.assertThat(res, is("lol"));
    }


    @Test(expected = NoSuchElementException.class)
    public void remove() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(0, "lol");
        map.put(2, "haha");
        map.remove(2);
        map.get(2);

    }

    @Test
    public void whenRemoveSizeMinus() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(0, "lol");
        map.put(2, "haha");
        map.put(3, "haha");
        map.remove(2);
        Assert.assertEquals(2, map.size());

    }

    @Test
    public void increaseCapacityLoadFactor() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(0, "lol");
        map.put(2, "haha");
        map.put(3, "haha");
        map.put(4, "haha");
        map.put(5, "haha");
        map.put(6, "haha");
        map.put(7, "haha");
        map.put(8, "haha");
        map.put(9, "haha");
        map.put(10, "haha");
        map.put(11, "haha");
        map.put(12, "haha");

        Assert.assertEquals(12, map.size());
    }


    @Test
    public void whenGetIteratorFromEmptyListThenHasNextReturnFalse() {
        Map<Integer, String> map = new SimpleMap<>();
        Assert.assertFalse(map.iterator().hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetIteratorFromEmptyListThenNextThrowException() {
        Map<Integer, String> map = new SimpleMap<>();
        map.iterator().next();
    }


    @Test(expected = ConcurrentModificationException.class)
    public void whenAddAfterGetIteratorThenMustBeException() {
        Map<Integer, String> map = new SimpleMap<>();
        Iterator<Integer> iterator = map.iterator();
        map.put(4, "K");
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenRemoveAfterGetIteratorThenMustBeException() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(0, "@");
        Iterator<Integer> iterator = map.iterator();
        map.remove(0);
        iterator.next();
    }
}