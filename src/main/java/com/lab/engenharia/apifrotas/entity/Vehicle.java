package com.lab.engenharia.apifrotas.entity;

import com.lab.engenharia.apifrotas.model.enums.StatusEnum;
import com.lab.engenharia.apifrotas.model.enums.TypeEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Document
public class Vehicle {

    @Id
    private String id;

    private TypeEnum type;

    private Integer year;

    private String color;

    private Integer seatQuantity;

    private String model;

    private String brand;

    private StatusEnum status;

    private Boolean isActive;

    @Builder
    public Vehicle(
            String id,
            TypeEnum type,
            Integer year,
            String color,
            Integer seatQuantity,
            String model,
            String brand,
            StatusEnum status,
            Boolean isActive) {
        this.id = id;
        this.type = type;
        this.year = year;
        this.color = color;
        this.seatQuantity = seatQuantity;
        this.model = model;
        this.brand = brand;
        this.status = status;
        this.isActive = isActive;
    }
}
