package com.company.loanapi.repository;

import com.company.loanapi.enamuration.ActionStatus;
import com.company.loanapi.enamuration.FinalStatus;
import com.company.loanapi.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Modifying
    @Query(value = "INSERT INTO transaction (action_status, final_status, customer_id) " +
            "VALUES(?1, ?2, ?3)", nativeQuery = true)
    void createTransactionForCustomer(ActionStatus actionStatus, FinalStatus finalStatus, Integer customerId);

}
