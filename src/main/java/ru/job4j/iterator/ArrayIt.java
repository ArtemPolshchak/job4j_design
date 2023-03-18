package ru.job4j.iterator;

import java.util.Iterator;

/**
 * @author artem.polschak@gmail.com on 18.03.2023.
 * @project job4j_design
 */
public class ArrayIt implements Iterator<Integer> {

    private final int[] data;
    private int point = 0;

    public ArrayIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    @Override
    public Integer next() {
        return data[point++];
    }
}