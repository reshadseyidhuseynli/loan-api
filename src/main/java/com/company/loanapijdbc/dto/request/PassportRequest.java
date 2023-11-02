package com.company.loanapijdbc.dto.request;

import com.company.loanapijdbc.domain.enamuration.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PassportRequest {

    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthdate;
    private Gender gender;
    private Integer passportNumber;

}
