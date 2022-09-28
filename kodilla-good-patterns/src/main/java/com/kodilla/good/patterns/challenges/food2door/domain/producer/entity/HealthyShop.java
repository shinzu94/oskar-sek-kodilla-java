package com.kodilla.good.patterns.challenges.food2door.domain.producer.entity;

import com.kodilla.good.patterns.challenges.food2door.domain.order.model.OrderDto;
import com.kodilla.good.patterns.challenges.food2door.domain.order.model.ProducerOrderRequest;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.producerinfo.ProducerInfo;
import com.kodilla.good.patterns.challenges.food2door.domain.product.Product;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class HealthyShop implements Producer {
    private ProducerInfo producerInfo;
    private Map<Product, ProductsAvailability> productsAvailability;

    @Override
    public synchronized OrderDto process(ProducerOrderRequest orderRequest) {
        if (checkAvailabilitiesOfProducts(orderRequest.getProductOrderList())) {
            changeAvailabilities(orderRequest.getProductOrderList());
        }
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

    private boolean checkAvailabilitiesOfProducts(Map<Product, Integer> productCountEntries) {
        for (Map.Entry<Product, Integer> productCountEntry : productCountEntries.entrySet()) {
            if (!productsAvailability.containsKey(productCountEntry.getKey())
                    || productsAvailability.get(productCountEntry.getKey()).getUnits() < productCountEntry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean changeAvailabilities(Map<Product, Integer> productCountEntries) {
        for (Map.Entry<Product, Integer> productCountEntry : productCountEntries.entrySet()) {
            if (productsAvailability.containsKey(productCountEntry.getKey())) {
                return false;
            }
        }
        return true;
    }
}