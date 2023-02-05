package com.kodilla.good.patterns.challenges.food2door.domain;

import com.kodilla.good.patterns.challenges.food2door.domain.order.model.OrderRequest;
import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.Producer;
import com.kodilla.good.patterns.challenges.food2door.domain.product.Product;
import com.kodilla.good.patterns.challenges.food2door.domain.service.ProducerService;

import java.util.HashMap;
import java.util.Map;

public class Food2DoorApplication {

    private static final ProducerService orderService = new ProducerService();

    public static void main(String[] args) {
        Producer producer = orderService.getProducerList().get(0);
        Map<Product, Integer> productsInOrders = new HashMap<>();
        productsInOrders.put(new Product("Apple"), 5);
        productsInOrders.put(new Product("Orange"), 5);
        OrderRequest orderRequest = new OrderRequest(productsInOrders);

        orderService.printProducerDataWithAvailability(producer);
        orderService.order(producer, orderRequest);
    }
}
