package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author User on 20.12.2021.
 * @project job4j_design 5.1.1. Итератор для двухмерного массива int[][] [#9539]
 */
public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

     @Override
    public boolean hasNext() {
         while (row < data.length && column == data[row].length) {
            row++;
            column = 0;
         }
         return row < data.length && column < data[row].length;
     }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}
