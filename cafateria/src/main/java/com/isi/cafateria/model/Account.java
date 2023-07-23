package com.isi.cafateria.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    @OneToOne(mappedBy ="account")
    private Officer officer;
    @OneToOne(mappedBy = "account")
    private Employee employee;

}
