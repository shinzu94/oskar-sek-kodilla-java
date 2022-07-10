package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.infrastructure.ComponentRegistry;
import com.kodilla.good.patterns.challenges.infrastructure.OrderRequestRetriever;

public class ProductOrderApplication {
    private static OrderProcessor orderProcessor;

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = ComponentRegistry.getOrderRequestRetriever();
        orderProcessor = new OrderProcessor();
        orderProcessor.process(orderRequestRetriever.retrieve());
    }
}
