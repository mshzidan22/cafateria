package com.isi.cafateria.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "invoices")
public class Customer  {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double taresh;
    @ManyToOne()
    @JsonBackReference
    private CustomerType customerType;
    @OneToMany(mappedBy = "customer")
    private Set<Invoice> invoices;
    @OneToMany(mappedBy = "customer")
    private Set<Payment> payments;

}