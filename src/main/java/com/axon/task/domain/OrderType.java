package com.axon.task.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Nikolay on 20.09.2018.
 */
public enum OrderType {
    BID(0), ASK(1);

    private int id;

    OrderType(int id) {
        this.id = id;
    }

    public static OrderType getTypeById(int id) {
        return Arrays.stream(values()).filter(value -> value.id == id).collect(Collectors.toList()).get(0);
    }
}
