package com.lab.engenharia.apifrotas.repository;

import com.lab.engenharia.apifrotas.entity.Driver;
import com.lab.engenharia.apifrotas.model.enums.StatusEnum;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DriverRepository extends MongoRepository<Driver, String> {

    List<Driver> findAllByStatus(StatusEnum status);
}
