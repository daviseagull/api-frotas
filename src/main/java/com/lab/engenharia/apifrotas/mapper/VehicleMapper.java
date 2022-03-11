package com.lab.engenharia.apifrotas.mapper;

import com.lab.engenharia.apifrotas.entity.Vehicle;
import com.lab.engenharia.apifrotas.model.VehicleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

  VehicleMapper VEHICLE_MAPPER = Mappers.getMapper(VehicleMapper.class);

  VehicleDto toVehicleDto(Vehicle vehicle);

  Vehicle toVehicle(VehicleDto vehicleDto);
}
