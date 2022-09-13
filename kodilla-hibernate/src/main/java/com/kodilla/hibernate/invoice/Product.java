package com.kodilla.hibernate.invoice;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    @NotNull
    private String name;

    public Product(String name) {
        this.name = name;
    }
}
