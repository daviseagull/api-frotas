package com.lab.engenharia.apifrotas.v1.service;

import com.lab.engenharia.apifrotas.model.DriverDto;
import com.lab.engenharia.apifrotas.model.DriverSummaryDto;

import java.util.List;

public interface DriverService {

    DriverDto getDriverInfo(String id);

    List<DriverSummaryDto> getDriverByStatus(String status);

    DriverDto createDrive(DriverDto vehicleDto);

}
