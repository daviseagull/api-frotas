package com.lab.engenharia.apifrotas.v1.service.impl;

import com.lab.engenharia.apifrotas.mapper.DriverMapper;
import com.lab.engenharia.apifrotas.mock.DriverDtoMock;
import com.lab.engenharia.apifrotas.mock.DriverMock;
import com.lab.engenharia.apifrotas.mock.DriverSummaryDtoMock;
import com.lab.engenharia.apifrotas.repository.DriverRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.lab.engenharia.apifrotas.model.enums.StatusEnum.AVAILABLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DriverServiceImplTest {

    @Mock
    private DriverRepository repository;

    @Mock
    private DriverMapper mapper;

    @InjectMocks
    private DriverServiceImpl service;

    @Test
    void getDriverInfo() {
        var id = DriverMock.ID;
        var expected = DriverDtoMock.buildAvailableDriverDto();
        var driver = DriverMock.buildAvailableDriver();

        when(repository.findById(id)).thenReturn(Optional.of(driver));
        when(mapper.toDriverDto(driver)).thenReturn(expected);

        var result = service.getDriverInfo(id);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void getDriverByStatus() {
        var status = AVAILABLE;
        var driver = DriverMock.buildAvailableDriver();
        var driverSummary = DriverSummaryDtoMock.buildDriverSummary();
        var expected = List.of(DriverSummaryDtoMock.buildDriverSummary());

        when(repository.findAllByStatus(status)).thenReturn(List.of(driver));
        when(mapper.toDriverSummaryDto(driver)).thenReturn(driverSummary);

        var result = service.getDriverByStatus(status.getStatusValue());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void createDrive() {
        var unsavedDriverDto = DriverDtoMock.buildUnsavedDriverDto();
        var unsavedDriver = DriverMock.buildUnsavedDriver();
        var driver = DriverMock.buildAvailableDriver();

        var expected = DriverDtoMock.buildAvailableDriverDto();

        when(mapper.toDriver(unsavedDriverDto)).thenReturn(unsavedDriver);
        when(repository.save(unsavedDriver)).thenReturn(driver);
        when(mapper.toDriverDto(driver)).thenReturn(expected);

        var result = service.createDrive(unsavedDriverDto);

        assertThat(result).isEqualTo(expected);
    }
}