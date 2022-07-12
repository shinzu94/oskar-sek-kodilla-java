package com.kodilla.good.patterns.challenges.repository;


import com.kodilla.good.patterns.challenges.entity.OrderPosition;
import com.kodilla.good.patterns.challenges.infrastructure.repository.EntityRepository;
import com.kodilla.good.patterns.challenges.infrastructure.repository.annotation.Repository;

@Repository
public class OrderPositionRepository extends EntityRepository {
    public OrderPositionRepository() {
        super(OrderPosition.class);
    }
}
