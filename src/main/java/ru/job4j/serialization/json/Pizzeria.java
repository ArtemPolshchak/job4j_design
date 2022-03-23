package ru.job4j.serialization.json;

import java.util.Arrays;

/**
 * @author artem.polschak@gmail.com on 22.03.2022.
 * @project job4j_design
 * 1.Сериализация [#313163]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.4. Сериализация
 */
public class Pizzeria {
    private final boolean open;
    private final int numberOfDishes;
    private final Address address;
    private final String[] jobPositions;

    public Pizzeria(boolean open, int numberOfDishes, Address address, String[] jobPositions) {
        this.open = open;
        this.numberOfDishes = numberOfDishes;
        this.address = address;
        this.jobPositions = jobPositions;
    }

    @Override
    public String toString() {
        return "Pizzeria{" + "open=" + open
                + ", numberOfDishes=" + numberOfDishes
                + ", address=" + address
                + ", jobPositions=" + Arrays.toString(jobPositions)
                + '}';
    }
}