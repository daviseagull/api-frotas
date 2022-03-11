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

  @JsonValue
  public String getTypeName() {
    return typeName;
  }

  public String getTypeValue() {
    return typeValue;
  }

  public static Optional<TypeEnum> getInstance(String typeName) {
    return Arrays.stream(values())
        .filter(v -> v.getTypeName().equalsIgnoreCase(typeName))
        .findFirst();
  }
}
