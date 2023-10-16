package com.company.loanapi.config;

import com.company.loanapi.domain.*;
import com.company.loanapi.domain.enamuration.ActionStatus;
import com.company.loanapi.domain.enamuration.FinalStatus;
import com.company.loanapi.domain.enamuration.Gender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class RowMapperConfig {

    @Bean("addressRowMapper")
    public RowMapper<Address> getAddressRowMapper() {
        return (rs, rowNum) -> Address.builder()
                .id(rs.getInt("id"))
                .country(rs.getString("country"))
                .city(rs.getString("city"))
                .street(rs.getString("street"))
                .postalCode(rs.getString("postal_code"))
                .build();
    }

    @Bean("contactRowMapper")
    public RowMapper<Contact> getContactRowMapper() {
        return (rs, rowNum) -> Contact.builder()
                .id(rs.getInt("id"))
                .homeNumber(rs.getString("home_number"))
                .workNumber(rs.getString("work_number"))
                .mobileNumber(rs.getString("mobile_number"))
                .email(rs.getString("email"))
                .build();
    }

    @Bean("customerRowMapper")
    public RowMapper<Customer> getCustomerRowMapper() {
        return (rs, rowNum) -> Customer.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .patronymic(rs.getString("patronymic"))
                .birthdate(rs.getDate("birthdate").toLocalDate())
                .gender(Gender.item(rs.getInt("gender")))
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

    @Bean("loanProductRowMapper")
    public RowMapper<LoanProduct> getLoanProductRowMapper() {
        return (rs, rowNum) -> LoanProduct.builder()
                .id(rs.getInt("id"))
                .loanId(rs.getInt("loan_id"))
                .productId(rs.getInt("product_id"))
                .build();
    }

    @Bean("productRowMapper")
    public RowMapper<Product> getProductRowMapper() {
        return (rs, rowNum) -> Product.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .price(rs.getBigDecimal("price"))
                .build();
    }

    @Bean("transactionRowMapper")
    public RowMapper<Transaction> getTransactionRowMapper() {
        return (rs, rowNum) -> Transaction.builder()
                .id(rs.getInt("id"))
                .actionStatus(ActionStatus.item(rs.getInt("action_status")))
                .rejectReason(rs.getString("reject_reason"))
                .finalStatus(FinalStatus.item(rs.getInt("final_status")))
                .build();
    }
}
