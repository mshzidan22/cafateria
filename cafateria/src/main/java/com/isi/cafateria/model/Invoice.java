package com.isi.cafateria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "invoiceLinesList")
public class Invoice {
    private Long id;
    private LocalDateTime date;
    private Double totalPrice;
    private Boolean isPaid;

    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "invoice")
    private Set<InvoiceLine> invoiceLinesList;

}
