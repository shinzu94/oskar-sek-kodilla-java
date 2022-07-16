package com.kodilla.good.patterns.challenges.food2door.domain.producer.entity;

import com.kodilla.good.patterns.challenges.food2door.domain.order.model.OrderDto;
import com.kodilla.good.patterns.challenges.food2door.domain.order.model.ProducerOrderRequest;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.producerinfo.ProducerInfo;
import com.kodilla.good.patterns.challenges.food2door.domain.product.Product;

import java.util.Map;

public interface Producer {
    ProducerInfo getProducerInfo();

    Map<Product, ProductsAvailability> getProductsAvailability();

    OrderDto process(ProducerOrderRequest orderRequest);
}
