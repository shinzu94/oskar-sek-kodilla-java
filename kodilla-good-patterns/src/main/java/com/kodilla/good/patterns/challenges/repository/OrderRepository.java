package com.kodilla.good.patterns.challenges.repository;


import com.kodilla.good.patterns.challenges.entity.Order;

public class OrderRepository extends EntityRepository {
    public OrderRepository() {
        super(Order.class);
    }
}
