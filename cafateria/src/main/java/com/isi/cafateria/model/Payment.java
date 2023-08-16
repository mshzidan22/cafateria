package com.isi.cafateria.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Customer customer;
    @OneToOne(mappedBy = "payment")
    private Invoice invoice;

    private Double amountPaid;



}
