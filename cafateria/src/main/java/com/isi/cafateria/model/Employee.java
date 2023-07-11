package com.isi.cafateria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "invoices")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String info;
    @OneToOne
    private Account account;
    @ManyToMany()
    private Set<Officer> officerList;
    @OneToMany(mappedBy = "employee")
    private Set<Invoice> invoices;
}
