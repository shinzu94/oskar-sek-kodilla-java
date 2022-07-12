package com.kodilla.good.patterns.challenges.repository;

import com.kodilla.good.patterns.challenges.entity.Product;
import com.kodilla.good.patterns.challenges.infrastructure.repository.EntityRepository;
import com.kodilla.good.patterns.challenges.infrastructure.repository.annotation.Repository;

@Repository
public class ProductRepository extends EntityRepository {
    public ProductRepository() {
        super(Product.class);
    }
}
