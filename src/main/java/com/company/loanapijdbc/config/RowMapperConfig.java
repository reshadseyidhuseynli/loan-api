package com.company.loanapijdbc.config;

import com.company.loanapijdbc.domain.Customer;
import com.company.loanapijdbc.domain.Loan;
import com.company.loanapijdbc.domain.Transaction;
import com.company.loanapijdbc.domain.enamuration.ActionStatus;
import com.company.loanapijdbc.domain.enamuration.FinalStatus;
import com.company.loanapijdbc.domain.enamuration.Gender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class RowMapperConfig {

    @Bean("customerRowMapper")
    public RowMapper<Customer> getCustomerRowMapper() {
        return (rs, rowNum) -> Customer.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .patronymic(rs.getString("patronymic"))
                .birthdate(rs.getDate("birthdate").toLocalDate())
                .gender(Gender.item(rs.getString("gender")))
                .passportNumber(rs.getString("passport_number"))
                .contactId(rs.getInt("contact_id"))
                .addressId(rs.getInt("address_id"))
                .build();
    }

    @Bean("loanRowMapper")
    public RowMapper<Loan> getLoanRowMapper() {
        return (rs, rowNum) -> Loan.builder()
                .id(rs.getInt("id"))
                .totalAmount(rs.getBigDecimal("total_amount"))
                .preAmount(rs.getBigDecimal("pre_amount"))
                .interestRate(rs.getBigDecimal("interest_rate"))
                .build();
    }

    @Bean("transactionRowMapper")
    public RowMapper<Transaction> getTransactionRowMapper() {
        return (rs, rowNum) -> Transaction.builder()
                .id(rs.getInt("id"))
                .actionStatus(ActionStatus.item(rs.getString("action_status")))
                .rejectReason(rs.getString("reject_reason"))
                .finalStatus(FinalStatus.item(rs.getString("final_status")))
                .customerId(rs.getInt("customer_id"))
                .build();
    }
}
