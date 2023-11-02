package com.company.loanapijdbc.dto;

import com.company.loanapijdbc.domain.enamuration.ActionStatus;
import com.company.loanapijdbc.domain.enamuration.FinalStatus;
import lombok.Data;

@Data
public class TransactionDto {

    private Integer id;
    private ActionStatus actionStatus;
    private String rejectReason;
    private FinalStatus finalStatus;
    private Integer customerId;

}
