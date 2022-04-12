package com.lab.engenharia.apifrotas.v1.controller.impl;

import com.lab.engenharia.apifrotas.model.DriverDto;
import com.lab.engenharia.apifrotas.model.DriverSummaryDto;
import com.lab.engenharia.apifrotas.v1.controller.DriverController;
import com.lab.engenharia.apifrotas.v1.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("driver/v1")
@RequiredArgsConstructor
@Slf4j
public class DriverControllerImpl implements DriverController {

    private final DriverService driverService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DriverDto> getDriverInfo(@PathVariable String id) {
        return ok(driverService.getDriverInfo(id));
    }

    @Override
    @GetMapping("/drivers/status/{status}")
    public ResponseEntity<List<DriverSummaryDto>> getAllDriverByStatus(@PathVariable String status) {
        return ok(driverService.getDriverByStatus(status));
    }

    @Override
    @PostMapping
    public ResponseEntity<DriverDto> createDriver(DriverDto driverDto) {
        return ok(driverService.createDrive(driverDto));
    }
}
