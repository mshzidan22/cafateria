package com.isi.cafateria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "products")
public class Fatora {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private LocalDateTime data;
    private Double totalSell;
    private Double totalBuy;

    @ManyToOne
    private Officer officer;
    @ManyToMany(mappedBy = "fawateerSet")
    private Set<Product> products;
}
