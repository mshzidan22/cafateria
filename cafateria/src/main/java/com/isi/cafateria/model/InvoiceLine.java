package com.isi.cafateria.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class InvoiceLine {
    @Id
    @GeneratedValue
    private Long id;

    private Double amount;
    @Transient
    private Double unitPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;
    @ManyToOne
    private Invoice invoice;


}
