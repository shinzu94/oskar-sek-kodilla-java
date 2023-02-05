package com.kodilla.good.patterns.challenges.food2door.domain.producer.entity;

import com.kodilla.good.patterns.challenges.food2door.domain.order.model.OrderRequest;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.producerinfo.ProducerInfo;
import com.kodilla.good.patterns.challenges.food2door.domain.product.Product;

import java.util.Map;

public interface Producer {
    ProducerInfo getProducerInfo();

    Map<Product, ProductAvailability> getProductsAvailability();

    boolean process(OrderRequest orderRequest);
}
