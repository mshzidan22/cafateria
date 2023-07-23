package com.isi.cafateria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "customersList")
public class CustomerType {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double initalTaresha;
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customersList;
}
