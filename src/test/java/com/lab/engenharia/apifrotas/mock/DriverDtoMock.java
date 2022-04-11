package com.lab.engenharia.apifrotas.mock;

import com.lab.engenharia.apifrotas.model.DriverDto;
import com.lab.engenharia.apifrotas.model.enums.StatusEnum;

public class DriverDtoMock {

    public static DriverDto buildAvailableDriverDto() {
        return DriverDto.builder()
                .id(DriverMock.ID)
                .status(StatusEnum.AVAILABLE)
                .age(DriverMock.AGE)
                .name(DriverMock.NAME)
                .cnh(DriverMock.CNH)
                .build();
    }

    public static DriverDto buildUnsavedDriverDto() {
        return DriverDto.builder()
                .status(StatusEnum.AVAILABLE)
                .age(DriverMock.AGE)
                .name(DriverMock.NAME)
                .cnh(DriverMock.CNH)
                .build();
    }
}
