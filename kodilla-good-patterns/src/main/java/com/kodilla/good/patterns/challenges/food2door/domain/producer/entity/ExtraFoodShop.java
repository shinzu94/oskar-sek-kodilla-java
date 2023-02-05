package com.kodilla.good.patterns.challenges.food2door.domain.producer.entity;

import com.kodilla.good.patterns.challenges.food2door.domain.order.model.OrderRequest;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.producerinfo.ProducerInfo;
import com.kodilla.good.patterns.challenges.food2door.domain.product.Product;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class ExtraFoodShop implements Producer {

    private ProducerInfo producerInfo;

    private Map<Product, ProductAvailability> productsAvailability;

    public ExtraFoodShop() {
        prepareProductAvailability();
        producerInfo = new ProducerInfo("ExtraFoodShop");
    }

    private void prepareProductAvailability() {
        productsAvailability = new HashMap<>();
        Product orange = new Product("Orange");
        Product apple = new Product("Apple");
        productsAvailability.put(orange, new ProductAvailability(123.0, 32.0));
        productsAvailability.put(apple, new ProductAvailability(123.0, 32.0));
    }

    @Override
    public boolean process(OrderRequest orderRequest) {
        if (checkAvailabilitiesOfProducts(orderRequest.getProductOrderList())) {
            changeAvailabilities(orderRequest.getProductOrderList());
            return true;
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
