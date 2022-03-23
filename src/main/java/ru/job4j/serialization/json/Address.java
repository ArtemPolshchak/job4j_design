package ru.job4j.serialization.json;

/**
 * @author artem.polschak@gmail.com on 22.03.2022.
 * @project job4j_design
 * 2. Формат JSON [#313164]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.4. Сериализация
 */
public class Address {
    private final String address;

    public Address(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" + "address='"
                + address + '}';
    }
}
