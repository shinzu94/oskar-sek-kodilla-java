package com.kodilla.good.patterns.challenges.infrastructure;

import com.kodilla.good.patterns.challenges.repository.OrderRepository;
import com.kodilla.good.patterns.challenges.repository.ProductRepository;
import com.kodilla.good.patterns.challenges.service.ConsoleInformationService;
import com.kodilla.good.patterns.challenges.service.InformationServiceInterface;
import com.kodilla.good.patterns.challenges.service.OrderPositionService;
import com.kodilla.good.patterns.challenges.service.OrderService;

abstract public class ComponentRegistry {
    private static OrderService orderService;
    private static OrderPositionService orderPositionService;
    private static OrderRepository orderRepository;
    private static ProductRepository productRepository;
    private static InformationServiceInterface informationServiceInterface;
    private static OrderRequestRetriever orderRequestRetriever;

    public static OrderRepository getOrderRepository() {
        if (null == orderRepository) {
            orderRepository = new OrderRepository();
        }
        return orderRepository;
    }

    public static ProductRepository getProductRepository() {
        if (null == productRepository) {
            productRepository = new ProductRepository();
        }
        return productRepository;
    }

    public static OrderPositionService getOrderPositionService() {
        if (null == orderPositionService) {
            orderPositionService = new OrderPositionService();
        }
        return orderPositionService;
    }

    public static OrderService getOrderService() {
        if (null == orderService) {
            orderService = new OrderService();
        }
        return orderService;
    }

    public static InformationServiceInterface getInformationServiceInterface() {
        if (null == informationServiceInterface) {
            informationServiceInterface = new ConsoleInformationService();
        }
        return informationServiceInterface;
    }

    public static OrderRequestRetriever getOrderRequestRetriever() {
        if (null == orderRequestRetriever) {
            orderRequestRetriever = new OrderRequestRetriever();
        }
        return orderRequestRetriever;
    }
}
