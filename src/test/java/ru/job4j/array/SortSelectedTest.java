package ru.job4j.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class SortSelectedTest {

    @Test
     void whenSortAlreadySortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, SortSelected.sort(input));
    }

    @Test
     void whenSortReversedArray() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, SortSelected.sort(input));
    }

    @Test
     void whenSortUnsortedArray() {
        int[] input = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};
        assertArrayEquals(expected, SortSelected.sort(input));
    }

    @Test
     void whenSortArrayWithDuplicates() {
        int[] input = {2, 3, 2, 3, 1, 1};
        int[] expected = {1, 1, 2, 2, 3, 3};
        assertArrayEquals(expected, SortSelected.sort(input));
    }

    @Test
     void whenSortArrayWithSingleElement() {
        int[] input = {42};
        int[] expected = {42};
        assertArrayEquals(expected, SortSelected.sort(input));
    }

    @Test
     void whenSortEmptyArray() {
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, SortSelected.sort(input));
    }
}