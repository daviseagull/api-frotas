package com.lab.engenharia.apifrotas.v1.service.impl;

import com.lab.engenharia.apifrotas.exception.VehicleNotFoundException;
import com.lab.engenharia.apifrotas.model.VehicleDto;
import com.lab.engenharia.apifrotas.repository.VehicleRepository;
import com.lab.engenharia.apifrotas.v1.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.lab.engenharia.apifrotas.mapper.VehicleMapper.VEHICLE_MAPPER;

@Service
@Slf4j
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

  private final VehicleRepository repository;

  @Override
  public VehicleDto getVehicleInfo(Long code) {
    log.info("Getting vehicle with code {}", code);

    var vehicle =
        repository
            .findByCode(code)
            .orElseThrow(
                () -> new VehicleNotFoundException("Vehicle with code " + code + "not found."));

    log.debug("Returning vehicle with code {}: {}", code, vehicle);
    return VEHICLE_MAPPER.toVehicleDto(vehicle);
  }

  @Override
  public VehicleDto createVehicle(VehicleDto vehicleDto) {
    log.info("Salving vehicle: {}", vehicleDto);

    var vehicle = VEHICLE_MAPPER.toVehicle(vehicleDto);
    repository.save(vehicle);

    return vehicleDto;
  }

  @Override
  public List<VehicleDto> getAllVehicles() {
    log.info("Getting all vehicles");

    var vehicles = repository.findAll();

    var vehiclesDto = vehicles.stream().map(VEHICLE_MAPPER::toVehicleDto).toList();

    log.debug("Returning vehicles {}", vehiclesDto);
    return vehiclesDto;
  }
}
