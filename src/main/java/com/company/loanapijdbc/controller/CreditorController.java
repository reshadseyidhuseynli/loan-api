package com.company.loanapijdbc.controller;

import com.company.loanapijdbc.dto.request.LoanInformation;
import com.company.loanapijdbc.dto.request.PassportRequest;
import com.company.loanapijdbc.dto.request.PersonalInformation;
import com.company.loanapijdbc.service.CreditorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/creditor")
public class CreditorController {

    private final CreditorService creditorService;

    @PostMapping("/check-identity")
    public void checkIdentity(@RequestBody PassportRequest passportRequest) {

        creditorService.checkIdentity(passportRequest);

    }

    @PostMapping("/initial-approve")
    public void initialApprove(@RequestParam("transaction-id") Integer transactionId,
                               @RequestBody PersonalInformation personalInformation) {

        creditorService.initialApprove(transactionId, personalInformation);

    }

    @PostMapping("/final-approve")
    public void finalApprove(@RequestParam("transaction-id") Integer transactionId,
                             @RequestBody LoanInformation loanInformation) {

        creditorService.finalApprove(transactionId, loanInformation);

    }
}
