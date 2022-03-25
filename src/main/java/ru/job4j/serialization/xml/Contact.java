package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author artem.polschak@gmail.com on 23.03.2022.
 * @project job4j_design
 * 4. JAXB. Преобразование XML в POJO. [#315063]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.4. Сериализация
 */

@XmlRootElement(name = "contact")
public class Contact {

    @XmlAttribute
    private String phone;

    public Contact() {

    }

    public Contact(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}
