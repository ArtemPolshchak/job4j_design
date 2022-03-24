package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author artem.polschak@gmail.com on 22.03.2022.
 * @project job4j_design
 * 2. Формат JSON [#313164]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.4. Сериализация
 */

@XmlRootElement(name = "address")
public class Address {

    @XmlAttribute
    private String address;

    public Address() {

    }

    public Address(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" + "address='"
                + address + '}';
    }
}
