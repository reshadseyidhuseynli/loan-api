package com.company.loanapi.domain.enamuration;

import java.util.Arrays;

public enum FinalStatus {

    IN_PROGRESS(0),
    COMPLETED(1);

    private final int value;

    FinalStatus(int value) {
        this.value = value;
    }

    public static FinalStatus item(int value){
        return Arrays.stream(values())
                .filter(finalStatus -> finalStatus.value == value)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public int value() {
        return value;
    }

}
