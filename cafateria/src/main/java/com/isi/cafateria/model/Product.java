package com.isi.cafateria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "invoiceLineList ")
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
    @JsonIgnore
    private Category category;
    private Double amount;
    @ManyToOne
    @JsonIgnore

    private Fatora fatora;

    @OneToMany(mappedBy = "invoice")
    @JsonIgnore
    private Set<InvoiceLine> invoiceLineList;


}
