package com.kodilla.good.patterns.challenges.food2door.domain.service;

import com.kodilla.good.patterns.challenges.food2door.domain.order.model.OrderRequest;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.HealthyShop;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.Producer;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.ProductAvailability;
import com.kodilla.good.patterns.challenges.food2door.domain.product.Product;

import java.util.List;
import java.util.Map;

public class ProducerService {

    private static final List<Producer> producerList = List.of(
            new ExtraFoodShop(),
            new GlutenFreeShop(),
            new HealthyShop()
    );

    public boolean order(Producer producer, OrderRequest orderRequest) {
        System.out.printf("We process order to producer %s \n", producer.getProducerInfo().getName());
        for (Map.Entry<Product, Integer> entry : orderRequest.getProductOrderList().entrySet()) {
            System.out.printf("%s %s\n", entry.getKey().getName(), entry.getValue());
        }

        boolean result = producer.process(orderRequest);

        System.out.println(result ? "Order is successful" : "Order is failure");

        return result;
    }

    public void printProducerDataWithAvailability(Producer producer) {
        System.out.println(producer.getProducerInfo().getName());

        for (Map.Entry<Product, ProductAvailability> availabilityEntry : producer.getProductsAvailability().entrySet()) {
            System.out.printf("%s %s unit %s$ per units.\n",
                    availabilityEntry.getKey().getName(),
                    availabilityEntry.getValue().getUnits(),
                    availabilityEntry.getValue().getPrice()
            );
        }
    }

    public List<Producer> getProducerList() {
        return List.copyOf(producerList);
    }
}
