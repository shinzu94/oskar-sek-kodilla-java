package com.kodilla.hibernate.manytomany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @ManyToMany(mappedBy = "employees")
    public List<Company> companies;
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}