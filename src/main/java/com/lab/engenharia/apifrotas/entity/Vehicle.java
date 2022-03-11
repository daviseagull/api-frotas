package com.lab.engenharia.apifrotas.entity;

import com.lab.engenharia.apifrotas.model.enums.StatusEnum;
import com.lab.engenharia.apifrotas.model.enums.TypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
@Document
public class Vehicle implements Serializable {

  @Serial private static final long serialVersionUID = 3030627815715642262L;

  @Id
  @Indexed(unique = true)
  private Long code;

  private TypeEnum type;

  private Integer year;

  private String color;

  private Integer seatQuantity;

  private String model;

  private String brand;

  private StatusEnum status;
}
