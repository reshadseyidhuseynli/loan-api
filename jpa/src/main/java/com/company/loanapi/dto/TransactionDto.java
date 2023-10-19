package com.company.loanapi.dto;

import com.company.loanapi.enamuration.ActionStatus;
import com.company.loanapi.enamuration.FinalStatus;
import lombok.Data;

@Data
public class TransactionDto {

    private Integer id;
    private ActionStatus actionStatus;
    private String rejectReason;
    private FinalStatus finalStatus;
    private Integer customerId;

}
