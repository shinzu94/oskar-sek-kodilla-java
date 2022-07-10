package com.kodilla.good.patterns.challenges.service;

import com.kodilla.good.patterns.challenges.entity.Order;
import com.kodilla.good.patterns.challenges.entity.OrderPosition;
import com.kodilla.good.patterns.challenges.infrastructure.ComponentRegistry;
import com.kodilla.good.patterns.challenges.model.OrderRequest;
import com.kodilla.good.patterns.challenges.repository.OrderRepository;

import java.util.Optional;

public class OrderService {
    private final OrderPositionService orderPositionService = ComponentRegistry.getOrderPositionService();
    private final OrderRepository orderRepository = ComponentRegistry.getOrderRepository();

    public Optional<Order> order(OrderRequest orderRequest) {
        Order order = new Order(orderRequest.getOrdersPositions(), orderRequest.getAddress());
        if (validateOrder(order)) {
            String id = orderRepository.save(order).trim();
            if (!id.equals("")) {
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    private boolean validateOrder(Order order) {
        boolean valid = !order.getOrderPositions().isEmpty();
        for (OrderPosition orderPosition : order.getOrderPositions()) {
            if (!valid) break;
            valid = orderPositionService.validateOrderPosition(orderPosition);
        }
        return valid;
    }
}
