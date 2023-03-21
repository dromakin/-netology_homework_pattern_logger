/*
 * File:     Filter
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

import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    private final Logger logger = Logger.getInstance();

    private final int threshold;
    private int counter;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public int getCount() {
        return counter;
    }

    public List<Integer> filterOut(List<Integer> source) {
        return source.stream().filter(x -> {
            if (x < threshold) {
                logger.log(String.format("Элемент %d не проходит", x));
                return false;
            }

            logger.log(String.format("Элемент %d проходит", x));
            this.counter++;
            return true;
        }).collect(Collectors.toList());
    }

}
