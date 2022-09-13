package com.kodilla.hibernate.manytomany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Company {
    @ManyToMany
    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE",
            joinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")}
    )
    public List<Employee> employees;
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    @NotNull
    private String name;

    public Company(String name) {
        this.name = name;
    }
}