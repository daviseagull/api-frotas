package com.lab.engenharia.apifrotas.exception;

public class DriverNotFoundException extends RuntimeException {

    private final String message;

    public DriverNotFoundException(String message) {
        this.message = message;
    }
}
