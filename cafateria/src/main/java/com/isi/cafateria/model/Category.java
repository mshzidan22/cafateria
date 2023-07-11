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
@EqualsAndHashCode(exclude = "productList")
public class Category {
    @Id
    @GeneratedValue

private Long id;
private String name;
@OneToMany(mappedBy = "category")
private Set<Product> productList;

}
