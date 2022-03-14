package com.lab.engenharia.apifrotas.mapper;

import com.lab.engenharia.apifrotas.entity.Vehicle;
import com.lab.engenharia.apifrotas.model.VehicleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

  VehicleDto toVehicleDto(Vehicle vehicle);

  Vehicle toVehicle(VehicleDto vehicleDto);
}
