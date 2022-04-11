package com.lab.engenharia.apifrotas.v1.service.impl;

import com.lab.engenharia.apifrotas.exception.VehicleNotFoundException;
import com.lab.engenharia.apifrotas.mapper.VehicleMapper;
import com.lab.engenharia.apifrotas.model.VehicleDto;
import com.lab.engenharia.apifrotas.model.VehicleSummaryDto;
import com.lab.engenharia.apifrotas.model.enums.StatusEnum;
import com.lab.engenharia.apifrotas.repository.VehicleRepository;
import com.lab.engenharia.apifrotas.v1.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;

    private final VehicleMapper vehicleMapper;

    @Override
    public VehicleDto getVehicleInfo(String id) {
        log.info("Getting vehicle with id {}", id);

        var vehicle =
                repository
                        .findById(id)
                        .orElseThrow(
                                () -> new VehicleNotFoundException("Vehicle with id " + id + " not found."));

        log.debug("Returning vehicle with id {}: {}", id, vehicle);
        return vehicleMapper.toVehicleDto(vehicle);
    }

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        log.info("Salving vehicle: {}", vehicleDto);

        var vehicle = vehicleMapper.toVehicle(vehicleDto);
        var savedVehicle = repository.save(vehicle);

        return vehicleMapper.toVehicleDto(savedVehicle);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {

        log.info("Getting all vehicles.");
        var vehicles = repository.findAll();

        var vehiclesDto = vehicles.stream().map(vehicleMapper::toVehicleDto).toList();

        log.debug("Returning vehicles {}", vehiclesDto);
        return vehiclesDto;
    }

    @Override
    public List<VehicleSummaryDto> getVehiclesByStatus(String status) {
        log.info("Getting all vehicles by status: {}", status);

        var statusEnum = StatusEnum.getInstanceByValue(status).orElseThrow();

        var vehicles = repository.findAllByStatus(statusEnum);

        var vehiclesSummaryDto = vehicles.stream().map(vehicleMapper::toVehicleSummaryDto).toList();

        log.debug("Returning vehicleSummary {}", vehiclesSummaryDto);

        return vehiclesSummaryDto;
    }
}
