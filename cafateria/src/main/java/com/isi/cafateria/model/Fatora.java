package com.isi.cafateria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "productList")
public class Fatora {
    private Long id;
    private String code;
    private LocalDateTime data;
    private Double totalSell;
    private Double totalBuy;
    private Officer officer;
    @ManyToMany
    private Set<Product> productList;
}
