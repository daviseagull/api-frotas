package com.lab.engenharia.apifrotas.v1.service.impl;

import com.lab.engenharia.apifrotas.exception.DriverNotFoundException;
import com.lab.engenharia.apifrotas.mapper.DriverMapper;
import com.lab.engenharia.apifrotas.model.DriverDto;
import com.lab.engenharia.apifrotas.model.DriverSummaryDto;
import com.lab.engenharia.apifrotas.model.enums.StatusEnum;
import com.lab.engenharia.apifrotas.repository.DriverRepository;
import com.lab.engenharia.apifrotas.v1.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;

    private final DriverMapper mapper;

    @Override
    public DriverDto getDriverInfo(String id) {
        log.info("Getting driver with id {}", id);

        var driver =
                repository
                        .findById(id)
                        .orElseThrow(
                                () -> new DriverNotFoundException("Driver with id " + id + " not found."));

        log.debug("Returning driver with id {}: {}", id, driver);
        return mapper.toDriverDto(driver);
    }

    @Override
    public List<DriverSummaryDto> getDriverByStatus(String status) {
        log.info("Getting all drivers by status: {}", status);

        var statusEnum = StatusEnum.getInstanceByValue(status).orElseThrow();

        var drivers = repository.findAllByStatus(statusEnum);

        var driversSummaryDto = drivers.stream().map(mapper::toDriverSummaryDto).toList();

        log.debug("Returning driverSummary {}", driversSummaryDto);

        return driversSummaryDto;
    }

    @Override
    public DriverDto createDrive(DriverDto driverDto) {
        log.info("Salving driver: {}", driverDto);

        var driver = mapper.toDriver(driverDto);
        var savedDriver = repository.save(driver);

        return mapper.toDriverDto(savedDriver);
    }
}
