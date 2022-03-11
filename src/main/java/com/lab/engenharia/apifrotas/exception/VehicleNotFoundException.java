package com.lab.engenharia.apifrotas.exception;

public class VehicleNotFoundException extends RuntimeException {

    private final String message;

    public VehicleNotFoundException(String message) {
        this.message = message;
    }
}
