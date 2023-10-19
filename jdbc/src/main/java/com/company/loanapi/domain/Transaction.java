package com.company.loanapi.domain;

import com.company.loanapi.domain.enamuration.ActionStatus;
import com.company.loanapi.domain.enamuration.FinalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private Integer id;
    private ActionStatus actionStatus;
    private String rejectReason;
    private FinalStatus finalStatus;
    private Integer customerId;

}
