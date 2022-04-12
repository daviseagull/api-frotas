package com.lab.engenharia.apifrotas.entity;

import com.lab.engenharia.apifrotas.model.enums.StatusEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Document
public class Driver {

    @Id
    private String id;

    private StatusEnum status;

    private String name;

    private Long cnh;

    private Integer age;

    @Builder
    public Driver(String id, StatusEnum status, String name, Long cnh, Integer age) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.cnh = cnh;
        this.age = age;
    }
}
