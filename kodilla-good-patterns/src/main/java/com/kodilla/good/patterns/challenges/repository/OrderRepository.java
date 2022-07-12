package com.kodilla.good.patterns.challenges.repository;


import com.kodilla.good.patterns.challenges.entity.Order;
import com.kodilla.good.patterns.challenges.infrastructure.repository.EntityRepository;
import com.kodilla.good.patterns.challenges.infrastructure.repository.annotation.Repository;


@Repository
public class OrderRepository extends EntityRepository {
    public OrderRepository() {
        super(Order.class);
    }
}
