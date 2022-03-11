package com.lab.engenharia.apifrotas.repository;

import com.lab.engenharia.apifrotas.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    Optional<Vehicle> findByCode (Long code);
}
