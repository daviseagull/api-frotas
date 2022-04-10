package com.lab.engenharia.apifrotas.v1.service.impl;

import com.lab.engenharia.apifrotas.entity.Vehicle;
import com.lab.engenharia.apifrotas.exception.VehicleNotFoundException;
import com.lab.engenharia.apifrotas.mapper.VehicleMapper;
import com.lab.engenharia.apifrotas.model.VehicleDto;
import com.lab.engenharia.apifrotas.model.VehicleSummaryDto;
import com.lab.engenharia.apifrotas.model.enums.StatusEnum;
import com.lab.engenharia.apifrotas.model.enums.TypeEnum;
import com.lab.engenharia.apifrotas.repository.VehicleRepository;
import com.lab.engenharia.apifrotas.v1.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;

    private final VehicleMapper vehicleMapper;

    @Override
    public VehicleDto getVehicleInfo(String id) {
        log.info("Getting vehicle with code {}", id);

        var vehicle =
                repository
                        .findById(id)
                        .orElseThrow(
                                () -> new VehicleNotFoundException("Vehicle with code " + id + "not found."));

        log.debug("Returning vehicle with code {}: {}", id, vehicle);
        return vehicleMapper.toVehicleDto(vehicle);
    }

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        log.info("Salving vehicle: {}", vehicleDto);

        var vehicle = vehicleMapper.toVehicle(vehicleDto);
        repository.save(vehicle);

        return vehicleMapper.toVehicleDto(vehicle);
    }

    @Override
    public List<VehicleDto> getAllVehicles(Optional<String> statusOpt, Optional<String> typeOpt) {
        List<Vehicle> vehicles;

        if (statusOpt.isPresent() && typeOpt.isPresent()) {
            log.info("Getting vehicles filtered by status={} and type={}.", statusOpt.get(), typeOpt.get());
            var status = StatusEnum.getInstanceByName(statusOpt.get()).orElseThrow();
            var type = TypeEnum.getInstanceByName(typeOpt.get()).orElseThrow();

            vehicles = repository.findAllByStatusAndType(status, type);
        } else if (statusOpt.isPresent()) {
            log.info("Getting vehicles filtered by status={}.", statusOpt.get());
            var status = StatusEnum.getInstanceByName(statusOpt.get()).orElseThrow();
            vehicles = repository.findAllByStatus(status);
        } else if (typeOpt.isPresent()) {
            log.info("Getting vehicles filtered by type={}.", typeOpt.get());
            var type = TypeEnum.getInstanceByName(typeOpt.get()).orElseThrow();
            vehicles = repository.findAllByType(type);
        } else {
            log.info("Getting all vehicles.");
            vehicles = repository.findAll();
        }

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
