package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author artem.polschak@gmail.com on 22.03.2022.
 * @project job4j_design
 * 2. Формат JSON [#313164]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.4. Сериализация
 */
public class Main {
    public static void main(String[] args) {
        final Pizzeria pizzeria1 = new Pizzeria(true, 12,
                new Address("pizzeria street house 25"), "Manager", "Cook", "Waiter", "Cleaner");

        final Gson gson = new GsonBuilder().create();

        String convertToJson = gson.toJson(pizzeria1);
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

        JSONObject jsonAddress = new JSONObject("{\"address\":\"pizzeria street house 25\"}");

        List<String> list = new ArrayList<>();
        list.add("Cook");
        list.add("Waiter");
        list.add("Cleaner");
        JSONObject jsonJobPositions = new JSONObject(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("open", pizzeria1.isOpen());
        jsonObject.put("numberOfDishes", pizzeria1.getNumberOfDishes());
        jsonObject.put("address", jsonAddress);
        jsonObject.put("jobPositions", jsonJobPositions);

        System.out.println(jsonObject);

        System.out.println(new JSONObject(pizzeria1));
    }
}
