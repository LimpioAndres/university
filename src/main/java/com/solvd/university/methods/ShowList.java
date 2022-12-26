package com.solvd.university.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ShowList {

    private static final Logger LOGGER = LogManager.getLogger(ShowList.class);
    public static void listDetailed(List<?> list){

        list.stream().forEach((Object count) -> {
            LOGGER.info(count);
        });
    }

}
