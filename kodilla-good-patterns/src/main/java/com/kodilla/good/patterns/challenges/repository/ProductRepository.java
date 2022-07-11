package com.kodilla.good.patterns.challenges.repository;

import com.kodilla.good.patterns.challenges.entity.OrderPosition;
import com.kodilla.good.patterns.challenges.entity.Product;

public class ProductRepository extends EntityRepository {
    public ProductRepository() {
        super(Product.class);
        manyToOne.put(OrderPosition.class, "Product");
    }
}
