package com.isi.cafateria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"invoiceLineList , fawateerSet"})
public class Product {
@Id
@GeneratedValue
    private Long id;
    private String name;
    private String info;
    private Long barcode;
    private String img;
    private Double Purchasing;
    private Double unitPrice;
    @ManyToOne
    private Category category;
    private Double amount;
    @ManyToMany
    @JoinTable(name = "FAWATEER_PRODUCTS")
    private Set<Fatora> fawateerSet;

    @OneToMany(mappedBy = "invoice")
    private Set<InvoiceLine> invoiceLineList;


}
