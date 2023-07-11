package com.isi.cafateria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "customersList")
public class CustomerType {
    private Long id;
    private String name;
    private Double initalTaresha;
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customersList;
}
