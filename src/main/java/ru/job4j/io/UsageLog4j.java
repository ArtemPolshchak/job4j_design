package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author artem.polschak@gmail.com on 21.03.2022.
 * @project job4j_design
 * 1. Log4j. Логирование системы. [#95335]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.3. Логгирование
 */

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte numByte = 8;
        short numShort = 16;
        int numInt = 32;
        long numLong = 64;
        char numChar = 16;
        float numFloat = 32f;
        double numDouble = 64d;
        boolean check = true;

        LOG.debug("Primitive Data Types have the following size byte : {}, short : {}, "
                + "int : {}, long : {}, char : {}, "
                + "float : {}, double : {}, boolean : {} ",
                numByte, numShort, numInt, numLong, numChar, numFloat, numDouble, check);

    }
}
