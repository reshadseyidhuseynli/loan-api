package com.company.loanapi.dto.response;

import com.company.loanapi.domain.enamuration.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerResponse {

    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthdate;
    private Gender gender;
    private String passportNumber;
    private ContactResponse contact;
    private AddressResponse address;
    private TransactionResponse transaction;

}
