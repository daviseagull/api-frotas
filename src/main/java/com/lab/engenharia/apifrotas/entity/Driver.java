package com.lab.engenharia.apifrotas.entity;

import com.lab.engenharia.apifrotas.model.enums.StatusEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Document
public class Driver implements Serializable {

    @Serial
    private static final long serialVersionUID = -1196198317286745091L;

    @Id
    private String id;

    private StatusEnum status;

    private String name;

    private Long cnh;

    private Integer age;
}
