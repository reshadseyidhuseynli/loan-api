package com.company.loanapi.entity;

import com.company.loanapi.enamuration.ActionStatus;
import com.company.loanapi.enamuration.FinalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "action_status")
    private ActionStatus actionStatus;
    @Column(name = "reject_reason")
    private String rejectReason;
    @Column(name = "final_status")
    private FinalStatus finalStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}
