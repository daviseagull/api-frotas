package com.lab.engenharia.apifrotas.mapper;

import com.lab.engenharia.apifrotas.entity.Driver;
import com.lab.engenharia.apifrotas.model.DriverDto;
import com.lab.engenharia.apifrotas.model.DriverSummaryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    DriverDto toDriverDto(Driver driver);

    DriverSummaryDto toDriverSummaryDto(Driver driver);

    Driver toDriver(DriverDto driverDto);
}
