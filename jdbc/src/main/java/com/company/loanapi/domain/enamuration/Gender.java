package com.company.loanapi.domain.enamuration;

import java.util.Arrays;

public enum Gender {

    MALE("MALE"),
    FEMALE("FEMALE");

    private final String value;

    Gender(String  value) {
        this.value = value;
    }

    public static Gender item(String value) {
        return Arrays.stream(values())
                .filter(gender -> gender.value().equals(value))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public String value(){
        return value;
    }

}
