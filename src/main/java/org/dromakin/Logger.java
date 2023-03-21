/*
 * File:     Logger
 * Package:  org.dromakin
 * Project:  netology_homework_pattern_logger
 *
 * Created by dromakin as 21.03.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.03.21
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package org.dromakin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    private static Logger instance;
    private static int count = 0;

    private Logger() {
    }

    public void log(String msg) {

        StringBuilder builder = new StringBuilder();
        builder.append("[")
                .append(DATE_TIME_FORMATTER.format(LocalDateTime.now()))
                .append(" ")
                .append(++count)
                .append("] ")
                .append(msg);

        System.out.println(builder);
    }

    public static Logger getInstance() {

        Logger result = instance;

        if (result != null) {
            return result;
        }

        synchronized (Logger.class) {
            if (result == null) {
                instance = new Logger();
            }

            return instance;
        }

    }

}
