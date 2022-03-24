package ru.job4j.serialization.xml;

import ru.job4j.serialization.json.Address;
import ru.job4j.serialization.json.Pizzeria;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author artem.polschak@gmail.com on 23.03.2022.
 * @project job4j_design
 * 4. JAXB. Преобразование XML в POJO. [#315063]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.4. Сериализация
 */

public class Main {
    public static void main(String[] args) throws Exception {
        Pizzeria pizzeria = new Pizzeria(true, 12,
                new Address("pizzeria street house 25"), "Manager", "Cook", "Waiter");
        JAXBContext context = JAXBContext.newInstance(Pizzeria.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(pizzeria, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Pizzeria result = (Pizzeria) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
