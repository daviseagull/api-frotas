package com.lab.engenharia.apifrotas.mock;

import com.lab.engenharia.apifrotas.model.VehicleSummaryDto;

import static com.lab.engenharia.apifrotas.mock.VehicleMock.*;
import static com.lab.engenharia.apifrotas.model.enums.StatusEnum.AVAILABLE;
import static com.lab.engenharia.apifrotas.model.enums.TypeEnum.BUS;
import static com.lab.engenharia.apifrotas.model.enums.TypeEnum.CAR;

public class VehicleSummaryDtoMock {

    public static VehicleSummaryDto buildAvailableBus() {
        return VehicleSummaryDto.builder()
                .id(BUS_ID)
                .model(BUS_MODEL)
                .seatQuantity(BUS_SEAT_QUANTITY)
                .status(AVAILABLE)
                .type(BUS)
                .build();
    }

    public static VehicleSummaryDto buildAvailableCar() {
        return VehicleSummaryDto.builder()
                .id(CAR_ID)
                .model(CAR_MODEL)
                .seatQuantity(CAR_SEAT_QUANTITY)
                .status(AVAILABLE)
                .type(CAR)
                .build();
    }
}
