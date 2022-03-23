package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author artem.polschak@gmail.com on 22.03.2022.
 * @project job4j_design
 * 2. Формат JSON [#313164]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.4. Сериализация
 */
public class Main {
    public static void main(String[] args) {
        final Pizzeria person = new Pizzeria(true, 12,
                new Address("pizzeria street house 25"),
                new String[] {"Manager", "Cook", "Waiter", "Cleaner"});

        final Gson gson = new GsonBuilder().create();

        String convertToJson = gson.toJson(person);
        System.out.println(convertToJson);

        final Pizzeria pizzeria = gson.fromJson(convertToJson, Pizzeria.class);
        System.out.println(pizzeria);

        final String pizzeria2 =
                "{"
                        + "\"open\":false,"
                        + "\"numberOfDishes\":11,"
                        + "\"address\":"
                        + "{"
                        + "\"address\":\"pizzeria street house 18\""
                        + "},"
                        + "\"jobPositions\":"
                        + "[\"Cook\",\"Waiter\",\"Cleaner\"]"
                        + "}";

        final Pizzeria pizzeriaAccount = gson.fromJson(pizzeria2, Pizzeria.class);
        System.out.println(pizzeriaAccount);

        String convertToJson2 = gson.toJson(pizzeriaAccount, Pizzeria.class);
        System.out.println(convertToJson2);

    }
}
