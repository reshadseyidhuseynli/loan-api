package com.company.loanapi.domain.enamuration;

import java.util.Arrays;

public enum Gender {

    MALE(1),
    FEMALE(2);

    private final int value;

    Gender(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }

    public static Gender item(int value) {
        return Arrays.stream(values())
                .filter(gender -> gender.value == value)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

}
