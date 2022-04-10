package com.lab.engenharia.apifrotas.mock;

import com.lab.engenharia.apifrotas.model.VehicleDto;

import java.util.List;

import static com.lab.engenharia.apifrotas.mock.VehicleMock.*;
import static com.lab.engenharia.apifrotas.model.enums.StatusEnum.AVAILABLE;
import static com.lab.engenharia.apifrotas.model.enums.TypeEnum.BUS;
import static com.lab.engenharia.apifrotas.model.enums.TypeEnum.CAR;

public class VehicleDtoMock {

    public static VehicleDto buildAvailableCar() {
        return VehicleDto.builder()
                .year(CAR_YEAR)
                .brand(CAR_BRAND)
                .model(CAR_MODEL)
                .type(CAR)
                .seatQuantity(CAR_SEAT_QUANTITY)
                .id(CAR_ID)
                .color(CAR_COLOR)
                .status(AVAILABLE)
                .build();
    }

    public static VehicleDto buildAvailableBus() {
        return VehicleDto.builder()
                .year(BUS_YEAR)
                .brand(BUS_BRAND)
                .model(BUS_MODEL)
                .type(BUS)
                .seatQuantity(BUS_SEAT_QUANTITY)
                .id(BUS_ID)
                .color(BUS_COLOR)
                .status(AVAILABLE)
                .build();
    }

    public static List<VehicleDto> buildAvailableVehicles() {
        return List.of(buildAvailableCar(), buildAvailableBus());
    }

    public static VehicleDto buildNotSavedCar() {
        return VehicleDto.builder()
                .year(CAR_YEAR)
                .brand(CAR_BRAND)
                .model(CAR_MODEL)
                .type(CAR)
                .seatQuantity(CAR_SEAT_QUANTITY)
                .color(CAR_COLOR)
                .status(AVAILABLE)
                .build();
    }
}
