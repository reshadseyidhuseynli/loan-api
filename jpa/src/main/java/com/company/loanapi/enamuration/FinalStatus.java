package com.company.loanapi.enamuration;

import java.util.Arrays;

public enum FinalStatus {

    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED");

    private final String value;

    FinalStatus(String value) {
        this.value = value;
    }

    public static FinalStatus item(String value){
        return Arrays.stream(values())
                .filter(finalStatus -> finalStatus.value().equals(value))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public String value(){
        return value;
    }

}
