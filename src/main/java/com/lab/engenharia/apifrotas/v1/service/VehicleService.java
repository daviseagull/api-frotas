package com.lab.engenharia.apifrotas.v1.service;

import com.lab.engenharia.apifrotas.model.VehicleDto;

import java.util.List;

public interface VehicleService {

  VehicleDto getVehicleInfo(String id);

  List<VehicleDto> getAllVehicles();

  VehicleDto createVehicle(VehicleDto vehicleDto);
}
