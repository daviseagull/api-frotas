package com.lab.engenharia.apifrotas.model;

import com.lab.engenharia.apifrotas.model.enums.StatusEnum;
import com.lab.engenharia.apifrotas.model.enums.TypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class VehicleDto implements Serializable {

  @Serial private static final long serialVersionUID = 3227682698395451989L;

  @Schema(name = "id", description = "Vehicle's id", required = true)
  private String id;

  @Schema(name = "type", description = "Vehicle's type", example = "Carro", required = true)
  @NotNull
  private TypeEnum type;

  @Schema(name = "year", description = "Vehicle's year", example = "2015", required = true)
  @NotNull
  private Integer year;

  @Schema(name = "color", description = "Vehicle's color", example = "Preto", required = true)
  @NotBlank
  private String color;

  @Schema(
      name = "seatQuantity",
      description = "Vehicle's seat quantity",
      example = "5",
      required = true)
  @NotNull
  private Integer seatQuantity;

  @Schema(name = "model", description = "Vehicle's model", example = "Onix", required = true)
  @NotBlank
  private String model;

  @Schema(name = "brand", description = "Vehicle's brand", example = "Chevrolet", required = true)
  @NotBlank
  private String brand;

  @Schema(
      name = "status",
      description = "Vehicle's status",
      example = "Disponível",
      required = true)
  @NotNull
  private StatusEnum status;

  @Builder
  public VehicleDto(
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

  public VehicleDto() {}
}
