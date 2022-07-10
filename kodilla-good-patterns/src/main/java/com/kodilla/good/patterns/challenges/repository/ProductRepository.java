package com.kodilla.good.patterns.challenges.repository;

import com.kodilla.good.patterns.challenges.entity.EntityInterface;
import com.kodilla.good.patterns.challenges.entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductRepository extends AbstractRepository {
    private static final List<EntityInterface> list = new ArrayList<>();

    static {
        list.add(new Product(UUID.fromString("d4b8232a-b22a-4512-88a8-d4a437e6e966"),
                "Pen",
                BigDecimal.valueOf(4.0)
        ));
        list.add(new Product(UUID.fromString("12051952-eddd-493c-b75d-22ad90cea732"),
                "Notebook",
                BigDecimal.valueOf(2000)
        ));
        list.add(new Product(UUID.fromString("31cf1e99-b061-4cae-9fcc-36c9df851bf5"),
                "Fan",
                BigDecimal.valueOf(400)
        ));
        list.add(new Product(UUID.fromString("7a368c86-73ac-40df-8d6f-c75d7189ece6"),
                "Cup",
                BigDecimal.valueOf(35)
        ));
    }

    @Override
    protected List<EntityInterface> getList() {
        return list;
    }
}
