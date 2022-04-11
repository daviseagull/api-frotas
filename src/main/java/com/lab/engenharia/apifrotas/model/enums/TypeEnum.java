package com.lab.engenharia.apifrotas.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Optional;

public enum TypeEnum {
    CAR("car", "Carro"),
    VAN("van", "Van"),
    BUS("bus", "Ônibus");

    private final String typeValue;

    private final String typeName;

    TypeEnum(String typeValue, String typeName) {
        this.typeValue = typeValue;
        this.typeName = typeName;
    }

    public static Optional<TypeEnum> getInstanceByValue(String typeValue) {
        return Arrays.stream(values())
                .filter(v -> v.getTypeValue().equalsIgnoreCase(typeValue))
                .findFirst();
    }

    public static Optional<TypeEnum> getInstanceByName(String typeName) {
        return Arrays.stream(values())
                .filter(v -> v.getTypeName().equalsIgnoreCase(typeName))
                .findFirst();
    }

    @JsonValue
    public String getTypeName() {
        return typeName;
    }

    public String getTypeValue() {
        return typeValue;
    }
}
