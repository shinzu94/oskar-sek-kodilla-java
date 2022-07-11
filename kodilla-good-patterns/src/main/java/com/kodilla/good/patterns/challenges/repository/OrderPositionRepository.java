package com.kodilla.good.patterns.challenges.repository;


import com.kodilla.good.patterns.challenges.entity.OrderPosition;

public class OrderPositionRepository extends EntityRepository {
    public OrderPositionRepository() {
        super(OrderPosition.class);
    }
}
