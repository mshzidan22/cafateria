package com.isi.cafateria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Data
@EqualsAndHashCode(exclude = "empList")
public class Officer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private Double initialCapital ;
    private Double Capital;
    @OneToOne
    private Account account;
    @ManyToMany(mappedBy = "officerList")
    private Set<Employee> emplist;

}
