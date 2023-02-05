package com.kodilla.patterns2.adapter.company.newhrsystem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class Employee {
    final private String peselId;
    final private String firstname;
    final private String lastname;
    final private BigDecimal baseSalary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return Objects.equals(peselId, employee.peselId);
    }

    @Override
    public int hashCode() {
        return peselId != null ? peselId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "peselId=" + peselId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}