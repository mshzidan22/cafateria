package com.isi.cafateria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "invoiceLinesList")
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime date;
    private Double totalPrice;
    private Boolean isPaid;

    @ManyToOne
    private Employee employee;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;
    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL)
    private Set<InvoiceLine> invoiceLinesList;
    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

}
