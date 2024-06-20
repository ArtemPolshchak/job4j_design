package ru.job4j.map;

import java.util.*;

/**
 * @author Artem Polshchak on 17.01.2022.
 * @project job4j_design 8. Реализовать собственную структуру данных - HashMap [#1008]
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.5. Map
 */
public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int modCount = 0;
    private int size = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    /**
     * Метод добавляет в HashMap новоще значение с параметрами key, value.
     * преобразовует создает для key hashCode, затем создает индекс
     * если ячейка по данному индексу пуста, то метод вносит в данную ячейку обьект MapEntry c key, value
     * затем метод проверяет заполненность LOAD_FACTOR массива с помощью метода expand()
     * @param key уникальный ключ SimpleMap
     * @param value значение, которое идет в паре с ключем
     * @return true если значение и ключь добавлены в массив
     */
    @Override
    public boolean put(K key, V value) {
        expand();
        boolean res = false;
        int index = indexFor(hash(key));

        if (table[index] == null) {
            table[index] = new MapEntry<K, V>(key, value);
            res = true;
            size++;
            modCount++;
        }
        return res;
    }

    /**
     * Метод возвращает размер коллекции
     * @return размер SimpleMap
     */
    public int size() {
        return size;
    }

    /**
     * Метод создает хэш-значение для ключа, который добавляется в коллекцию
     * @param key ключ, для которого создается хэш-значение
     * @return хэш-значение
     */
    private int hash(Object key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * Метод формирует индес ключа, по которому объект будет добавляться в массив  с уникальными ключами
     * @param hash хэш-значение, из которого формируется индекс
     * @return индекс для массива
     */
    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    /**
     * Метод проверяет заполненность массива,
     * если заполненность равняется или превышает 0.75 от общего размера, то массив увеличивается вдвое.
     */
    private void expand() {
        if (size >= table.length * LOAD_FACTOR) {
            capacity = capacity * 2;
            table = Arrays.copyOf(table, capacity);
            MapEntry<K, V>[] box = new MapEntry[capacity];
            for (int i = 0; i < capacity - 1; i++) {
                if (table[i] != null) {
                    K key = table[i].key;
                    int index = indexFor(hash(key));
                    if (box[index] == null) {
                        box[index] = table[i];
                    }
                }
            }
            table = Arrays.copyOf(box, capacity);
        }
    }

    /**
     * Метод подучает value по ключу key, если данное значение имеется в массиве,
     * в противном случае выбрасывает исключение NoSuchElementException
     * @param key ключь, по которому метод получает value
     * @return value, если ячейка под данным индексом не null
     */
    @Override
    public V get(K key) {
        V value = null;
        int index = indexFor(hash(key));
        if (table[index] != null) {

            if (hash(table[index].key) == hash(key)) {
                value = table[index].value;
            }
        } else {
            throw new NoSuchElementException();
        }

        return value;
    }

    /**
     * Метод удаляет значение из массива по ключу
     * @param key ключь, по которому производится удаление
     * @return true если искомое значение удалено
     */
    @Override
    public boolean remove(K key) {

        boolean res = false;
        int index = indexFor(hash(key));
        if (table[index] != null) {
            if (hash(table[index].key) == hash(key)) {
                table[index] = null;
                res = true;
                size--;
                modCount++;
            }
        } else {
                throw new NoSuchElementException();
        }
        return res;
    }


    /**
     * Метод осуществляет перебор элементов массива
     * @return значения массива по очереди.
     */
    @Override
    public Iterator iterator() {

        return new Iterator<>() {
            final int expectModCount = modCount;
            int cursor = 0;

            @Override
            public boolean hasNext() {
                if (modCount != expectModCount) {
                    throw new ConcurrentModificationException();
                }
                while (cursor < table.length && table[cursor] == null) {
                    cursor++;
                }
                return cursor < size;
            }

            @Override
            public MapEntry<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[cursor++];
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
