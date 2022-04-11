package com.lab.engenharia.apifrotas.v1.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.engenharia.apifrotas.mock.VehicleDtoMock;
import com.lab.engenharia.apifrotas.mock.VehicleMock;
import com.lab.engenharia.apifrotas.mock.VehicleSummaryDtoMock;
import com.lab.engenharia.apifrotas.v1.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.lab.engenharia.apifrotas.model.enums.StatusEnum.AVAILABLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VehicleControllerImpl.class)
@WithMockUser(username = "portal", roles = {"USER", "ADMIN"})
@ActiveProfiles("test")
class VehicleControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private VehicleService vehicleService;

    private static String writeValueAsString(Object value) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(value);
    }

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter((request, response, chain) -> {
                            response.setCharacterEncoding("UTF-8");
                            chain.doFilter(request, response);
                        },
                        "/*")
                .build();
    }

    @Test
    void getVehicleInfo() throws Exception {
        var id = VehicleMock.CAR_ID;
        var vehicleDto = VehicleDtoMock.buildAvailableCar();

        when(vehicleService.getVehicleInfo(id)).thenReturn(vehicleDto);

        var response = this.mockMvc.perform(
                        get("/vehicle/v1/" + id)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var expected = writeValueAsString(vehicleDto);

        assertThat(response).isEqualTo(expected);
    }

    @Test
    void getVehicles() throws Exception {
        var vehicles = VehicleDtoMock.buildAvailableVehicles();

        when(vehicleService.getAllVehicles()).thenReturn(vehicles);

        var response = this.mockMvc.perform(
                        get("/vehicle/v1/vehicles")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var expected = writeValueAsString(vehicles);

        assertThat(response).isEqualTo(expected);
    }

    @Test
    void getAllVehiclesByStatus() throws Exception {
        var status = AVAILABLE.getStatusValue();
        var vehicleDto = VehicleSummaryDtoMock.buildAvailableVehicles();

        when(vehicleService.getVehiclesByStatus(status)).thenReturn(vehicleDto);

        var response = this.mockMvc.perform(
                        get("/vehicle/v1/vehicles/status/" + status)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var expected = writeValueAsString(vehicleDto);

        assertThat(response).isEqualTo(expected);
    }

    @Test
    void createVehicle() throws Exception {
        var vehicle = VehicleDtoMock.buildNotSavedCar();
        var vehicleDto = VehicleDtoMock.buildAvailableCar();

        when(vehicleService.createVehicle(vehicle)).thenReturn(vehicleDto);

        var response = this.mockMvc.perform(
                        post("/vehicle/v1")
                                .content(writeValueAsString(vehicle))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var expected = writeValueAsString(vehicleDto);

        assertThat(response).isEqualTo(expected);
    }
}