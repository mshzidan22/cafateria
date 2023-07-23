package com.isi.cafateria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "products")
public class Fatora {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private LocalDateTime date;
    private Double totalSell;
    private Double totalBuy;

    @ManyToOne
    private Officer officer;
    @OneToMany(mappedBy = "fatora",cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();
}
