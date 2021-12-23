package ru.job4j.generics;

/**
 * @author User on 23.12.2021.
 * @project job4j_design 0. Что такое обобщенные типы (generics) [#4952]
 */
public class GenericsClass<K, V> {
    private K key;
    private V value;

    public GenericsClass(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericsClass{"
                + "key=" + key
                + ", value=" + value + '}';
    }

    public static void main(String[] args) {
        GenericsClass<String, String> gen = new GenericsClass<>("F", "S");
        System.out.println(gen);

        GenericsClass<Integer, String> genericsClass = new GenericsClass<>(1, "faf");
        System.out.println(genericsClass);
    }
}
