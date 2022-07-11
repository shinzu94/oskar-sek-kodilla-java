package com.kodilla.good.patterns.challenges.service;

import com.kodilla.good.patterns.challenges.entity.Order;
import com.kodilla.good.patterns.challenges.entity.OrderPosition;
import com.kodilla.good.patterns.challenges.infrastructure.ComponentRegistry;
import com.kodilla.good.patterns.challenges.model.OrderRequest;
import com.kodilla.good.patterns.challenges.repository.OrderPositionRepository;
import com.kodilla.good.patterns.challenges.repository.OrderRepository;

import java.util.Optional;

public class OrderService {
    private final OrderPositionService orderPositionService = ComponentRegistry.getOrderPositionService();
    private final OrderRepository orderRepository = ComponentRegistry.getOrderRepository();
    private final OrderPositionRepository orderPositionRepository = ComponentRegistry.getOrderPositionRepository();

    public Optional<Order> order(OrderRequest orderRequest) {
        Order order = new Order(orderRequest.getOrdersPositions(), orderRequest.getAddress());
        if (validateOrder(order)) {
            savePositions(order);
            orderRepository.save(order);
            return Optional.of(order);
        }
        return Optional.empty();
    }

    private boolean validateOrder(Order order) {
        boolean valid = !order.getOrderPositions().isEmpty();
        if (valid) {
            for (OrderPosition orderPosition : order.getOrderPositions()) {
                valid = orderPositionService.validateOrderPosition(orderPosition);
                if (!valid) break;
            }
        }
        return valid;
    }

    private void savePositions(Order order) {
        for (OrderPosition orderPosition : order.getOrderPositions()) {
            orderPositionRepository.save(orderPosition);
        }
    }
}
