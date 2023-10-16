package com.company.loanapi.domain;

import com.company.loanapi.domain.enamuration.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthdate;
    private Gender gender;
    private String passportNumber;
    private Integer contactId;
    private Integer addressId;
    private Integer transactionId;

}
