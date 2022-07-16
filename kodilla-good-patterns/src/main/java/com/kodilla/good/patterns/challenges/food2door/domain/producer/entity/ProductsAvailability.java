package com.kodilla.good.patterns.challenges.food2door.domain.producer.entity;

import com.kodilla.good.patterns.challenges.food2door.domain.product.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductsAvailability {
    private Product product;
    private double units;
    private BigDecimal price;
}
