package com.lab.engenharia.apifrotas.mapper;

import com.lab.engenharia.apifrotas.entity.Vehicle;
import com.lab.engenharia.apifrotas.model.VehicleDto;
import com.lab.engenharia.apifrotas.model.VehicleSummaryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

  VehicleDto toVehicleDto(Vehicle vehicle);

  VehicleSummaryDto toVehicleSummaryDto(Vehicle vehicle);

  Vehicle toVehicle(VehicleDto vehicleDto);
}
