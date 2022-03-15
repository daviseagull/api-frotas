package com.lab.engenharia.apifrotas.model;

import com.lab.engenharia.apifrotas.model.enums.StatusEnum;
import com.lab.engenharia.apifrotas.model.enums.TypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class VehicleSummaryDto implements Serializable {

  @Serial private static final long serialVersionUID = 2231709541896838273L;

  @Schema(name = "id", description = "Vehicle's id", required = true)
  private String id;

  @Schema(name = "type", description = "Vehicle's type", example = "Carro", required = true)
  @NotNull
  private TypeEnum type;

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

  @Schema(
      name = "status",
      description = "Vehicle's status",
      example = "Disponível",
      required = true)
  @NotNull
  private StatusEnum status;
}
