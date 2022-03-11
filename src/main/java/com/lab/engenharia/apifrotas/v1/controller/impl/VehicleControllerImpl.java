package com.lab.engenharia.apifrotas.v1.controller.impl;

import com.lab.engenharia.apifrotas.model.VehicleDto;
import com.lab.engenharia.apifrotas.v1.controller.VehicleController;
import com.lab.engenharia.apifrotas.v1.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("vehicle/v1")
@RequiredArgsConstructor
@Slf4j
public class VehicleControllerImpl implements VehicleController {

  private final VehicleService vehicleService;

  @Override
  @GetMapping("/{code}")
  public ResponseEntity<VehicleDto> getVehicleInfo(@PathVariable(value = "code") Long code) {
    return ok(vehicleService.getVehicleInfo(code));
  }

  @Override
  @GetMapping("/vehicles")
  public ResponseEntity<List<VehicleDto>> getAllVehicles() {
    return ok(vehicleService.getAllVehicles());
  }

  @Override
  @PostMapping
  public ResponseEntity<VehicleDto> createVehicle(@RequestBody @Valid VehicleDto vehicleDto) {
    return ok(vehicleService.createVehicle(vehicleDto));
  }
}
