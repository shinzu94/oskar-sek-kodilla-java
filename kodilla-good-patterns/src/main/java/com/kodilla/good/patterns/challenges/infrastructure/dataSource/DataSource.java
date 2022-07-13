package com.kodilla.good.patterns.challenges.infrastructure.dataSource;

import com.kodilla.good.patterns.challenges.entity.Order;
import com.kodilla.good.patterns.challenges.entity.OrderPosition;
import com.kodilla.good.patterns.challenges.entity.Product;
import com.kodilla.good.patterns.challenges.infrastructure.entity.EntityInterface;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataSource implements DataSourceInterface {
    private static final Map<String, EntityInterface> orderMap = new HashMap();
    private static final Map<String, EntityInterface> orderPositionMap = new HashMap();
    private static final Map<String, EntityInterface> productMap = new HashMap();

    static {
        String id1 = "d4b8232a-b22a-4512-88a8-d4a437e6e966";
        String id2 = "12051952-eddd-493c-b75d-22ad90cea732";
        String id3 = "31cf1e99-b061-4cae-9fcc-36c9df851bf5";
        String id4 = "7a368c86-73ac-40df-8d6f-c75d7189ece6";
        productMap.put(id1, new Product(UUID.fromString(id1),
                "Pen",
                BigDecimal.valueOf(4.0)
        ));
        productMap.put(id2, new Product(UUID.fromString(id2),
                "Notebook",
                BigDecimal.valueOf(2000)
        ));
        productMap.put(id3, new Product(UUID.fromString(id3),
                "Fan",
                BigDecimal.valueOf(400)
        ));
        productMap.put(id4, new Product(UUID.fromString(id4),
                "Cup",
                BigDecimal.valueOf(35)
        ));
    }

    @Override
    public Map<String, EntityInterface> getData(Class<? extends EntityInterface> entityClass) {
        if (Order.class.equals(entityClass)) {
            return orderMap;
        } else if (Product.class.equals(entityClass)) {
            return productMap;
        } else if (OrderPosition.class.equals(entityClass)) {
            return orderPositionMap;
        } else {
            throw new RuntimeException("Nonexistent data type");
        }
    }

}
