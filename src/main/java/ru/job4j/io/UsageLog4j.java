package ru.job4j.io;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author artem.polschak@gmail.com on 21.03.2022.
 * @project job4j_design
 * 1. Log4j. Логирование системы. [#95335]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.3. Логгирование
 */

public class UsageLog4j {
    private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
