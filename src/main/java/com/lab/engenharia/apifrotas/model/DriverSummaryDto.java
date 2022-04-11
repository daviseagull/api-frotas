package com.lab.engenharia.apifrotas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
public class DriverSummaryDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1305887525866604024L;

    @Schema(name = "id", description = "Driver's id", required = true)
    private String id;

    @Schema(name = "name", description = "Driver's Name", example = "João", required = true)
    @NotNull
    private String name;
}
