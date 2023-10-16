package com.company.loanapi.dto.request;

import com.company.loanapi.domain.enamuration.Gender;
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
