package com.lab.engenharia.apifrotas.mock;

import com.lab.engenharia.apifrotas.model.DriverSummaryDto;

public class DriverSummaryDtoMock {

    public static DriverSummaryDto buildDriverSummary() {
        return DriverSummaryDto.builder()
                .id(DriverMock.ID)
                .name(DriverMock.NAME)
                .build();
    }
}
