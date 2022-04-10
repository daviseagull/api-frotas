package com.lab.engenharia.apifrotas.v1.service.impl;

import com.lab.engenharia.apifrotas.exception.VehicleNotFoundException;
import com.lab.engenharia.apifrotas.mapper.VehicleMapper;
import com.lab.engenharia.apifrotas.mock.VehicleDtoMock;
import com.lab.engenharia.apifrotas.mock.VehicleMock;
import com.lab.engenharia.apifrotas.mock.VehicleSummaryDtoMock;
import com.lab.engenharia.apifrotas.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.lab.engenharia.apifrotas.model.enums.StatusEnum.AVAILABLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private VehicleMapper vehicleMapper;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Test
    void testGetVehicleByIdWithValidId() {
        var id = VehicleMock.CAR_ID;
        var vehicle = VehicleMock.buildAvailableCar();
        var expected = VehicleDtoMock.buildAvailableCar();

        when(vehicleRepository.findById(id)).thenReturn(Optional.of(vehicle));
        when(vehicleMapper.toVehicleDto(vehicle)).thenReturn(expected);

        var result = vehicleService.getVehicleInfo(id);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testGetVehicleByIdWithInvalidId() {
        var id = VehicleMock.CAR_ID;

        when(vehicleRepository.findById(id)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> vehicleService.getVehicleInfo(id))
                .isInstanceOf(VehicleNotFoundException.class);
    }

    @Test
    void createVehicle() {
        var notPersistedVehicle = VehicleDtoMock.buildNotSavedCar();
        var expected = VehicleDtoMock.buildAvailableCar();
        var vehicle = VehicleMock.buildAvailableCar();

        when(vehicleMapper.toVehicle(notPersistedVehicle)).thenReturn(vehicle);
        when(vehicleRepository.save(vehicle)).thenReturn(vehicle);
        when(vehicleMapper.toVehicleDto(vehicle)).thenReturn(expected);

        var result = vehicleService.createVehicle(notPersistedVehicle);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void getAllVehicles() {
        var car = VehicleMock.buildAvailableCar();
        var carDto = VehicleDtoMock.buildAvailableCar();
        var bus = VehicleMock.buildAvailableBus();
        var busDto = VehicleDtoMock.buildAvailableBus();
        var vehicles = List.of(car, bus);
        var expected = List.of(carDto, busDto);

        when(vehicleRepository.findAll()).thenReturn(vehicles);
        when(vehicleMapper.toVehicleDto(car)).thenReturn(carDto);
        when(vehicleMapper.toVehicleDto(bus)).thenReturn(busDto);

        var result = vehicleService.getAllVehicles();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void getVehiclesByStatus() {
        var car = VehicleMock.buildAvailableCar();
        var carSummary = VehicleSummaryDtoMock.buildAvailableCar();
        var bus = VehicleMock.buildAvailableBus();
        var busSummary = VehicleSummaryDtoMock.buildAvailableBus();

        var vehicles = List.of(car, bus);
        var expected = List.of(carSummary, busSummary);

        when(vehicleRepository.findAllByStatus(AVAILABLE)).thenReturn(vehicles);
        when(vehicleMapper.toVehicleSummaryDto(car)).thenReturn(carSummary);
        when(vehicleMapper.toVehicleSummaryDto(bus)).thenReturn(busSummary);

        var result = vehicleService.getVehiclesByStatus(AVAILABLE.getStatusValue());

        assertThat(result).isEqualTo(expected);
    }
}