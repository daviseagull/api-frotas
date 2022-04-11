package com.lab.engenharia.apifrotas.mock;

import com.lab.engenharia.apifrotas.entity.Driver;

import static com.lab.engenharia.apifrotas.model.enums.StatusEnum.AVAILABLE;
import static com.lab.engenharia.apifrotas.model.enums.StatusEnum.UNAVAILABLE;

public class DriverMock {

    public static final Long CNH = Long.valueOf("50154015057");
    public static final int AGE = 33;
    public static final String NAME = "João";
    public static final String ID = "62542587da8b3f0c2f0e8d0c";

    public static Driver buildAvailableDriver() {
        return Driver.builder()
                .cnh(CNH)
                .age(AGE)
                .name(NAME)
                .id(ID)
                .status(AVAILABLE)
                .build();
    }

    public static Driver buildUnsavedDriver() {
        return Driver.builder()
                .cnh(CNH)
                .age(AGE)
                .name(NAME)
                .id(ID)
                .status(UNAVAILABLE)
                .build();
    }
}
