package com.kodilla.hibernate.manytomany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Employee.findEmployeesByLastname",
                query = "FROM Employee WHERE lastname = :lastname"

        ),
        @NamedQuery(
                name = "Employee.findByName",
                query = "FROM Employee WHERE concat(firstname, ' ', lastname) like :name"
        )
})
@Entity
@Setter
@Getter
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
    @ManyToMany(mappedBy = "employees", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Company> companies = new LinkedList<>();

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}