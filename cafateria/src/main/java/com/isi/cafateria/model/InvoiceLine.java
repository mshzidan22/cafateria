package com.isi.cafateria.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class InvoiceLine {
    @Id
    @GeneratedValue
    private Long id;
    @Transient
    private Double amount;
    @Transient
    private Double unitPrice;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Invoice invoice;


}
