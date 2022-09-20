package com.kodilla.hibernate.manytomany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;


@NamedNativeQuery(
        name = "Company.findByFirstThreeLetters",
        query = "SELECT * FROM COMPANY" +
                " WHERE SUBSTRING(COMPANY.NAME, 1, 3) = SUBSTRING(:firstThreeLetters, 1, 3)",
        resultClass = Company.class

)
@Entity
@Data
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    @NotNull
    private String name;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE",
            joinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")}
    )
    private List<Employee> employees = new LinkedList<>();

    public Company(String name) {
        this.name = name;
    }
}