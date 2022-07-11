package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.infrastructure.ComponentRegistry;
import com.kodilla.good.patterns.challenges.infrastructure.Initializer;
import com.kodilla.good.patterns.challenges.infrastructure.OrderRequestRetriever;

public class ProductOrderApplication {
    public static void main(String[] args) {
        Initializer.init();
        OrderRequestRetriever orderRequestRetriever = ComponentRegistry.getOrderRequestRetriever();
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.process(orderRequestRetriever.retrieve());
    }
}
