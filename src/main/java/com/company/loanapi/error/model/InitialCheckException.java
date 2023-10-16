package com.company.loanapi.error.model;

public class InitialCheckException extends RuntimeException{

    private String message;

    public InitialCheckException(String message) {
        super(message);
        this.message = message;
    }
}
