package ru.job4j.array;

public class FindLoop {

    public static int indexInRange(int[] data, int el, int start, int end) {
        int result = -1;
        for (int i = start; i <= end; i++) {
            if (data[i] == el) {
                result = i;
                return result;
            }
        }
        return result;
    }
}
