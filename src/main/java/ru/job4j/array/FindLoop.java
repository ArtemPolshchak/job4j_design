package ru.job4j.array;

public class FindLoop {
    public static int indexInRange(int[] data, int el, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (data[i] == el) {
                return i;
            }
        }
        return -1;
    }
}
