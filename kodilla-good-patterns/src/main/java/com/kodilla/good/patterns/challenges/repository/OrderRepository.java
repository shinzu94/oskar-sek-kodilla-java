package com.kodilla.good.patterns.challenges.repository;


import com.kodilla.good.patterns.challenges.entity.EntityInterface;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository extends AbstractRepository {
    private static final List<EntityInterface> list = new ArrayList<>();

    @Override
    protected List<EntityInterface> getList() {
        return list;
    }
}
