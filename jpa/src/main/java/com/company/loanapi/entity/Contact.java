package com.company.loanapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "home_number")
    private String homeNumber;
    @Column(name = "work_number")
    private String workNumber;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "email")
    private String email;

}
