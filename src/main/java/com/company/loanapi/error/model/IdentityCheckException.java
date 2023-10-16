package com.company.loanapi.error.model;

public class IdentityCheckException extends RuntimeException{

    private String message;

    public IdentityCheckException(String message) {
        super(message);
        this.message = message;
    }
}
