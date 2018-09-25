package com.axon.task.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Nikolay on 25.09.2018.
 */
public enum OperationType {
    DELETE(2), ADD(0);

    private int id;

    OperationType(int id) {
        this.id = id;
    }

    public static OperationType getTypeById(int id) {
        return Arrays.stream(values()).filter(value -> value.id == id).collect(Collectors.toList()).get(0);
    }
}
