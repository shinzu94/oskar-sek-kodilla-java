package com.kodilla.good.patterns.challenges.food2door.domain.producer.entity;

import com.kodilla.good.patterns.challenges.food2door.domain.order.model.OrderRequest;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.producerinfo.ProducerInfo;
import com.kodilla.good.patterns.challenges.food2door.domain.product.Product;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@AllArgsConstructor
public class GlutenFreeShop implements Producer {

    private ProducerInfo producerInfo;

    private Map<Product, ProductAvailability> productsAvailability;

    public GlutenFreeShop() {
        productsAvailability = new HashMap<>();
        producerInfo = new ProducerInfo("GlutenFreeShop");
    }

    @Override
    public boolean process(OrderRequest orderRequest) {
        if (checkAvailabilitiesOfProducts(orderRequest.getProductOrderList())) {
            changeAvailabilities(orderRequest.getProductOrderList());
            return new Random().nextBoolean();
        }
        return false;
    }

    @Override
    public ProducerInfo getProducerInfo() {
        return producerInfo;
    }

    @Override
    public Map<Product, ProductAvailability> getProductsAvailability() {
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