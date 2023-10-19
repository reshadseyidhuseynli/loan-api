package com.company.loanapi.controller;

import com.company.loanapi.enamuration.LeadReply;
import com.company.loanapi.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/lead")
public class LeadController {

    private final LeadService leadService;

    @PostMapping("/identity-status/{id}")
    public void identityStatus(@PathVariable("id") Integer id,
                               @RequestParam LeadReply reply,
                               @RequestParam(required = false) String rejectReason) {
        leadService.identifyStatus(id, reply, rejectReason);
    }

    @PostMapping("/initial-status/{id}")
    public void initialStatus(@PathVariable("id") Integer id,
                              @RequestParam LeadReply reply,
                              @RequestParam(required = false) String rejectReason) {
        leadService.initialStatus(id, reply, rejectReason);
    }

    @PostMapping("/final-status/{transaction-id}")
    public void finalStatus(@PathVariable("transaction-id") Integer id,
                            @RequestParam LeadReply reply,
                            @RequestParam(required = false) String rejectReason) {
        leadService.finalStatus(id, reply, rejectReason);
    }
}