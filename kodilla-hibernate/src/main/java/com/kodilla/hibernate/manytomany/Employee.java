package com.kodilla.hibernate.manytomany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @ManyToMany(mappedBy = "employees")
    public List<Company> companies;

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}