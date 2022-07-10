package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.entity.Order;
import com.kodilla.good.patterns.challenges.infrastructure.ComponentRegistry;
import com.kodilla.good.patterns.challenges.model.OrderProcessDto;
import com.kodilla.good.patterns.challenges.model.OrderRequest;
import com.kodilla.good.patterns.challenges.service.InformationServiceInterface;
import com.kodilla.good.patterns.challenges.service.OrderService;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OrderProcessor {
    private final OrderService orderService = ComponentRegistry.getOrderService();
    private final InformationServiceInterface informationService = ComponentRegistry.getInformationServiceInterface();

    public OrderProcessDto process(OrderRequest orderRequest) {
        System.out.println("Order is being prepared.");
        Optional<Order> orderOptional = orderService.order(orderRequest);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            informationService.inform(buildMessageForPassedProcess(orderRequest, order));
            return new OrderProcessDto(orderRequest.getUser(), true);
        } else {
            informationService.inform("Order is rejected");
            return new OrderProcessDto(orderRequest.getUser(), false);
        }
    }

    private String buildMessageForPassedProcess(OrderRequest orderRequest, Order order) {
        String userName = orderRequest.getUser().getFullName();
        String message = userName + " does order \n";
        message += order.getOrderPositions().stream().map(orderPosition ->
                orderPosition.getCount() + " x " + orderPosition.getProduct().getName() + " for " + orderPosition.getProduct().getPrice() + "PLN"
        ).collect(Collectors.joining("\n"));
        message += "\nto address " + order.getAddress();
        return message;
    }
}
