package com.kodilla.good.patterns.challenges.infrastructure;

import com.kodilla.good.patterns.challenges.entity.OrderPosition;
import com.kodilla.good.patterns.challenges.entity.Product;
import com.kodilla.good.patterns.challenges.infrastructure.entity.EntityInterface;
import com.kodilla.good.patterns.challenges.model.OrderRequest;
import com.kodilla.good.patterns.challenges.model.User;
import com.kodilla.good.patterns.challenges.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class OrderRequestRetriever {
    private final ProductRepository productRepository = ComponentRegistry.getProductRepository();

    public OrderRequest retrieve() {
        Optional<EntityInterface> product = productRepository.find("12051952-eddd-493c-b75d-22ad90cea732");
        if (product.isEmpty()) {
            throw new RuntimeException("Nonexistent product");
        }
        List<OrderPosition> orderPositions = List.of(
                new OrderPosition((Product) product.get(), 3)
        );
        return OrderRequest.builder()
                .user(new User("Jan", "Kowalski"))
                .ordersPositions(orderPositions)
                .address("Warszawa, ul. Dmowskiego 54")
                .orderDateTime(LocalDateTime.now())
                .build();
    }
}
