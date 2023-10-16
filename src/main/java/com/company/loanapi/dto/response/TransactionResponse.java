package com.company.loanapi.dto.response;

import com.company.loanapi.domain.enamuration.ActionStatus;
import com.company.loanapi.domain.enamuration.FinalStatus;
import lombok.Data;

@Data
public class TransactionResponse {

    private Integer id;
    private ActionStatus actionStatus;
    private String rejectReason;
    private FinalStatus finalStatus;
}
