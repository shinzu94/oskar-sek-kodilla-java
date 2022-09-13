package com.kodilla.hibernate.invoice;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @NotNull
    private Product product;
    @NotNull
    private BigDecimal price;
    @NotNull
    private int quantity;
    @NotNull
    private BigDecimal value;
    @ManyToOne()
    private Invoice invoice;

    public Item() {
    }

    public Item(Product product, BigDecimal price, int quantity, BigDecimal value) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }
}
