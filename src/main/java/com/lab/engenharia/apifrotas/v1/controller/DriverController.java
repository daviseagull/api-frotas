package com.lab.engenharia.apifrotas.v1.controller;

import com.lab.engenharia.apifrotas.model.DriverDto;
import com.lab.engenharia.apifrotas.model.DriverSummaryDto;
import com.lab.engenharia.apifrotas.model.VehicleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DriverController {

    @Operation(
            summary = "Endpoint to get info of one driver",
            responses = {
                    @ApiResponse(
                            description = "Data obtained with success.",
                            responseCode = "200",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = VehicleDto.class))),
                    @ApiResponse(
                            description =
                                    "The Request was malformed, omitting mandatory attributes, either in the payload or through attributes in the url.",
                            responseCode = "400",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class))),
                    @ApiResponse(
                            description = "Unmapped Error.",
                            responseCode = "500",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Object.class)))
            })
    ResponseEntity<DriverDto> getDriverInfo(@PathVariable(value = "id") String id);

    @Operation(
            summary = "Endpoint to get info of all driver by status",
            responses = {
                    @ApiResponse(
                            description = "Data obtained with success.",
                            responseCode = "200",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = VehicleDto.class)))),
                    @ApiResponse(
                            description =
                                    "The Request was malformed, omitting mandatory attributes, either in the payload or through attributes in the url.",
                            responseCode = "400",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class))),
                    @ApiResponse(
                            description = "Unmapped Error.",
                            responseCode = "500",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Object.class)))
            })
    ResponseEntity<List<DriverSummaryDto>> getAllDriverByStatus(
            @PathVariable(value = "status") String status);

    @Operation(
            summary = "Endpoint to create a driver",
            responses = {
                    @ApiResponse(
                            description = "Data obtained with success.",
                            responseCode = "200",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = VehicleDto.class))),
                    @ApiResponse(
                            description =
                                    "The Request was malformed, omitting mandatory attributes, either in the payload or through attributes in the url.",
                            responseCode = "400",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class))),
                    @ApiResponse(
                            description = "Unmapped Error.",
                            responseCode = "500",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Object.class)))
            })
    ResponseEntity<DriverDto> createDriver(@RequestBody DriverDto driverDto);
}
