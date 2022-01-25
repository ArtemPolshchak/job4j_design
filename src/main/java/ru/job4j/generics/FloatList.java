package ru.job4j.generics;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

/**
 * @author Artem Polshchak User on 23.12.2021.
 * @project job4j_design 0. Что такое обобщенные типы (generics) [#4952]
 */
public class FloatList extends ArrayList<Float> {
    public static void main(String[] args) {
        ArrayList<Float> listOfNumbers = new FloatList();

        Class actual = listOfNumbers.getClass();
        ParameterizedType type = (ParameterizedType) actual.getGenericSuperclass();
        System.out.println(type);
        Class parameter = (Class) type.getActualTypeArguments()[0];
        System.out.println(parameter);
    }
}
