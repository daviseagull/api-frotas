package com.lab.engenharia.apifrotas.model;

import com.lab.engenharia.apifrotas.model.enums.StatusEnum;
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
public class DriverDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 2675563421337649571L;

    @Schema(name = "id", description = "Driver's id", required = true)
    private String id;

    @Schema(name = "name", description = "Driver's Name", example = "João", required = true)
    @NotNull
    private String name;

    @Schema(
            name = "status",
            description = "Driver's status",
            example = "Disponível",
            required = true)
    @NotNull
    private StatusEnum status;

    @Schema(name = "cnh", description = "Driver's CNH", example = "89100195505", required = true)
    @NotNull
    private Long cnh;

    @Schema(name = "age", description = "Driver's age", example = "33", required = true)
    @NotBlank
    private Integer age;

    @Builder
    public DriverDto(String id, String name, StatusEnum status, Long cnh, Integer age) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.cnh = cnh;
        this.age = age;
    }

    public DriverDto() {
    }
}
