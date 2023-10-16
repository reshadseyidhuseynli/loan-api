package com.company.loanapi.error.model;

public class BadRequestException extends RuntimeException{

    private String message;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }
}
