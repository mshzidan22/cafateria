package com.isi.cafateria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Data
@EqualsAndHashCode(exclude = {"empList","fatoraList"})
public class Officer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double initialCapital ;
    private Double Capital;
    @OneToOne
    private Account account;
    @ManyToMany(mappedBy = "officerList")
    private Set<Employee> emplist;
    @OneToMany(mappedBy = "officer")
    private Set<Fatora> fatoraList;

}
