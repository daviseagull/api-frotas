package com.lab.engenharia.apifrotas.v1.controller;

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

public interface VehicleController {

  @Operation(
      summary = "Endpoint to get info of one vehicle",
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
  ResponseEntity<VehicleDto> getVehicleInfo(@PathVariable(value = "code") Long code);

  @Operation(
      summary = "Endpoint to get info of all vehicles in DB",
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
  ResponseEntity<List<VehicleDto>> getAllVehicles();

  @Operation(
      summary = "Endpoint to get info of one vehicle",
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
  ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto);
}
