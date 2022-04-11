package com.lab.engenharia.apifrotas.v1.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.engenharia.apifrotas.mock.DriverDtoMock;
import com.lab.engenharia.apifrotas.mock.DriverMock;
import com.lab.engenharia.apifrotas.mock.DriverSummaryDtoMock;
import com.lab.engenharia.apifrotas.v1.service.DriverService;
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

import java.util.List;

import static com.lab.engenharia.apifrotas.model.enums.StatusEnum.AVAILABLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DriverControllerImpl.class)
@WithMockUser(username = "portal", roles = {"USER", "ADMIN"})
@ActiveProfiles("test")
class DriverControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private DriverService driverService;

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
    void getDriverInfo() throws Exception {
        var id = DriverMock.ID;
        var driverDto = DriverDtoMock.buildAvailableDriverDto();

        when(driverService.getDriverInfo(id)).thenReturn(driverDto);

        var response = this.mockMvc.perform(
                        get("/driver/v1/" + id)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var expected = writeValueAsString(driverDto);

        assertThat(response).isEqualTo(expected);
    }

    @Test
    void getAllDriverByStatus() throws Exception {
        var status = AVAILABLE.getStatusValue();
        var driverSummaryDto = List.of(DriverSummaryDtoMock.buildDriverSummary());

        when(driverService.getDriverByStatus(status)).thenReturn(driverSummaryDto);

        var response = this.mockMvc.perform(
                        get("/driver/v1/drivers/status/" + status)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var expected = writeValueAsString(driverSummaryDto);

        assertThat(response).isEqualTo(expected);
    }

    @Test
    void createDriver() throws Exception {
        var unsavedDriverDto = DriverDtoMock.buildUnsavedDriverDto();
        var driverDto = DriverDtoMock.buildAvailableDriverDto();

        when(driverService.createDrive(unsavedDriverDto)).thenReturn(driverDto);

        var response = this.mockMvc.perform(
                        post("/driver/v1")
                                .content(writeValueAsString(unsavedDriverDto))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var expected = writeValueAsString(driverDto);

        assertThat(response).isEqualTo(expected);
    }
}