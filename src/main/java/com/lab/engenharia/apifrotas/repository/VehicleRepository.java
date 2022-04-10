package com.lab.engenharia.apifrotas.repository;

import com.lab.engenharia.apifrotas.entity.Vehicle;
import com.lab.engenharia.apifrotas.model.enums.StatusEnum;
import com.lab.engenharia.apifrotas.model.enums.TypeEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    Optional<Vehicle> findById(String code);

    List<Vehicle> findAllByStatus(StatusEnum status);

    List<Vehicle> findAllByStatusAndType(StatusEnum status, TypeEnum type);

    List<Vehicle> findAllByType(TypeEnum type);

}

