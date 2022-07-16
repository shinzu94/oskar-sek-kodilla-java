package com.kodilla.good.patterns.challenges.food2door.domain.producer.entity;

import com.kodilla.good.patterns.challenges.food2door.domain.entity.ProductsAvailability;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.producerinfo.ExtraFoodShopInfo;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.producerinfo.ProducerInfo;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.model.OrderDto;
import com.kodilla.good.patterns.challenges.food2door.domain.product.Product;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class ExtraFoodShop implements Producer {
    Map<Product, ProductsAvailability> productsAvailability;
    private ExtraFoodShopInfo producerInfo;

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
