package com.kodilla.good.patterns.challenges.food2door.domain.entity;

import com.kodilla.good.patterns.challenges.food2door.domain.product.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductsAvailability {
    Product product;
    double units;
    BigDecimal price;
}
