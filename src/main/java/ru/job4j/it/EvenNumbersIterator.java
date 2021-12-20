package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Polshchak Artem on 20.12.2021.
 * @project job4j_design 5.1.2. Создать итератор четные числа [#150]
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (index < data.length - 1 && data[index] % 2 != 0) {
            index++;
        }
        return data[index] % 2 == 0;
    }

    @Override
    public Integer next() {
       if (!hasNext()) {
           throw new NoSuchElementException();
       }
       return data[index++];
    }
}
