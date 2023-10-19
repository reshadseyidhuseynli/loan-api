package com.company.loanapi.domain.enamuration;

import java.util.Arrays;

public enum ActionStatus {

    WAITING_FOR_IDENTITY_APPROVE("WAITING_FOR_IDENTITY_APPROVE"),
    IDENTITY_CHECK_APPROVED("IDENTITY_CHECK_APPROVED"),
    WAITING_FOR_INITIAL_APPROVE("WAITING_FOR_INITIAL_APPROVE"),
    INITIAL_CHECK_APPROVED("INITIAL_CHECK_APPROVED"),
    WAITING_FOR_FINAL_APPROVE("WAITING_FOR_FINAL_APPROVE"),
    FINAL_CHECK_APPROVED("FINAL_CHECK_APPROVED");

    private final String value;

    ActionStatus(String value) {
        this.value = value;
    }

    public static ActionStatus item(String value) {
        return Arrays.stream(values())
                .filter(actionStatus -> actionStatus.value().equals(value))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public String value() {
        return value;
    }

}
