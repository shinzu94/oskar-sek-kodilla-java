package com.kodilla.good.patterns.challenges.food2door.domain.producer.entity;

import com.kodilla.good.patterns.challenges.food2door.domain.entity.ProductsAvailability;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.producerinfo.GlutenFreeShopInfo;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.producerinfo.ProducerInfo;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.model.OrderDto;
import com.kodilla.good.patterns.challenges.food2door.domain.product.Product;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class GlutenFreeShop implements Producer {
    GlutenFreeShopInfo producerInfo;
    Map<Product, ProductsAvailability> productsAvailability;

    @Override
    public OrderDto process() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ProducerInfo getProducerInfo() {
        return producerInfo;
    }

    @Override
    public Map<Product, ProductsAvailability> getProductsAvailability() {
        return productsAvailability;
    }
}
