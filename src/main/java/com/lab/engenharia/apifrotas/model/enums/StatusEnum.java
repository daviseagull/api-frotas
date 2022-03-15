package com.lab.engenharia.apifrotas.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Optional;

public enum StatusEnum {
  UNAVAILABLE("unavailable", "Indisponível"),
  AVAILABLE("available", "Disponível"),
  IN_MAINTENANCE("inMaintenance", "Em manutenção");

  private final String statusName;
  private final String statusValue;

  StatusEnum(String statusValue, String statusName) {
    this.statusValue = statusValue;
    this.statusName = statusName;
  }

  public static Optional<StatusEnum> getInstanceByName(String statusName) {
    return Arrays.stream(values())
        .filter(v -> v.getStatusName().equalsIgnoreCase(statusName))
        .findFirst();
  }

  public static Optional<StatusEnum> getInstanceByValue(String statusValue) {
    return Arrays.stream(values())
        .filter(v -> v.getStatusValue().equalsIgnoreCase(statusValue))
        .findFirst();
  }

  @JsonValue
  public String getStatusName() {
    return statusName;
  }

  public String getStatusValue() {
    return statusValue;
  }
}
