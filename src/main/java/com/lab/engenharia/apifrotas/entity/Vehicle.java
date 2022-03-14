package com.lab.engenharia.apifrotas.entity;

import com.lab.engenharia.apifrotas.model.enums.StatusEnum;
import com.lab.engenharia.apifrotas.model.enums.TypeEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Document
public class Vehicle implements Serializable {

  @Serial private static final long serialVersionUID = 3030627815715642262L;

  @Id private String id;

  private TypeEnum type;

  private Integer year;

  private String color;

  private Integer seatQuantity;

  private String model;

  private String brand;

  private StatusEnum status;

  @Builder
  public Vehicle(
      String id,
      TypeEnum type,
      Integer year,
      String color,
      Integer seatQuantity,
      String model,
      String brand,
      StatusEnum status) {
    this.id = id;
    this.type = type;
    this.year = year;
    this.color = color;
    this.seatQuantity = seatQuantity;
    this.model = model;
    this.brand = brand;
    this.status = status;
  }
}
