package com.kodilla.good.patterns.challenges.infrastructure;

import com.kodilla.good.patterns.challenges.entity.OrderPosition;
import com.kodilla.good.patterns.challenges.entity.Product;
import com.kodilla.good.patterns.challenges.infrastructure.entity.EntityInterface;
import com.kodilla.good.patterns.challenges.model.OrderRequest;
import com.kodilla.good.patterns.challenges.model.User;
import com.kodilla.good.patterns.challenges.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRequestRetriever {
    private final ProductRepository productRepository = ComponentRegistry.getProductRepository();

    public OrderRequest retrieve() {
        List<OrderPosition> orderPositions = new ArrayList<>();
        Optional<EntityInterface> product = productRepository.find("12051952-eddd-493c-b75d-22ad90cea732");
        product.orElseThrow(() -> new RuntimeException("Nie ma takiego produktu"));
        orderPositions.add(new OrderPosition(
                (Product) product.get(),
                3
        ));
        return new OrderRequest(
                new User("Jan", "Kowalski"),
                orderPositions,
                "Warszawa, ul. Dmowskiego 54",
                LocalDateTime.now()
        );
    }
}
