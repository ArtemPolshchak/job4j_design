package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Artem Polshchak on 19.12.2021.
 * @project job4j_design 1. Что такое итератор. [#4951]
 */

public class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
     int point;

    public BackwardArrayIt(int[] data) {
        this.data = data;
        this.point = data.length - 1;
    }

    @Override
    public boolean hasNext() {
        return point >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point--];
    }
}
