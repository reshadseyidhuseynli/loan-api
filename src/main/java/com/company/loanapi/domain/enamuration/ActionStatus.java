package com.company.loanapi.domain.enamuration;

import java.util.Arrays;

public enum ActionStatus {

    WAITING_FOR_IDENTITY_APPROVE(1),
    IDENTITY_CHECK_APPROVED(2),
    WAITING_FOR_INITIAL_APPROVE(3),
    INITIAL_CHECK_APPROVED(4),
    WAITING_FOR_FINAL_APPROVE(5),
    FINAL_CHECK_APPROVED(6);

    private final int value;

    ActionStatus(int value) {
        this.value = value;
    }

    public static ActionStatus item(int value) {
        return Arrays.stream(values())
                .filter(actionStatus -> actionStatus.value() == value)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public int value() {
        return value;
    }

}
