package com.lab.engenharia.apifrotas.v1.service;

import com.lab.engenharia.apifrotas.model.VehicleDto;
import com.lab.engenharia.apifrotas.model.VehicleSummaryDto;

import java.util.List;

public interface VehicleService {

  VehicleDto getVehicleInfo(String id);

  List<VehicleDto> getAllVehicles();

  List<VehicleSummaryDto> getVehiclesByStatus(String status);

  VehicleDto createVehicle(VehicleDto vehicleDto);
}
