package com.lab.engenharia.apifrotas.mock;

import com.lab.engenharia.apifrotas.entity.Vehicle;

import static com.lab.engenharia.apifrotas.model.enums.StatusEnum.AVAILABLE;
import static com.lab.engenharia.apifrotas.model.enums.TypeEnum.BUS;
import static com.lab.engenharia.apifrotas.model.enums.TypeEnum.CAR;

public class VehicleMock {

    public static final String CAR_ID = "15543";
    public static final String CAR_BRAND = "Chevrolet";
    public static final String CAR_MODEL = "Onix";
    public static final String CAR_COLOR = "Preto";
    public static final int CAR_SEAT_QUANTITY = 5;
    public static final int CAR_YEAR = 2015;
    public static final String BUS_ID = "10043";
    public static final String BUS_BRAND = "Mercedes";
    public static final String BUS_MODEL = "O500";
    public static final String BUS_COLOR = "Cinza";
    public static final int BUS_SEAT_QUANTITY = 15;
    public static final int BUS_YEAR = 2012;

    public static Vehicle buildAvailableCar() {
        return Vehicle.builder()
                .id(CAR_ID)
                .brand(CAR_BRAND)
                .model(CAR_MODEL)
                .color(CAR_COLOR)
                .type(CAR)
                .year(CAR_YEAR)
                .seatQuantity(CAR_SEAT_QUANTITY)
                .status(AVAILABLE)
                .build();
    }

    public static Vehicle buildAvailableBus() {
        return Vehicle.builder()
                .id(BUS_ID)
                .brand(BUS_BRAND)
                .model(BUS_MODEL)
                .color(BUS_COLOR)
                .type(BUS)
                .year(BUS_YEAR)
                .seatQuantity(BUS_SEAT_QUANTITY)
                .status(AVAILABLE)
                .build();
    }
}
