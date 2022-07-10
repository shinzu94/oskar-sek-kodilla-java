package com.kodilla.good.patterns.challenges.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Data
@RequiredArgsConstructor
public class Order implements EntityInterface {
    protected static Map<String, String> relations = new HashMap<>();
    private UUID uuid;
    @NonNull
    private List<OrderPosition> orderPositions;
    @NonNull
    private String address;

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return (uuid.equals(order.uuid));
    }

    @Override
    public int hashCode() {
        return 31 * uuid.hashCode();
    }

    @Override
    public Optional<String> getId() {
        return uuid != null ? Optional.of(uuid.toString()) : Optional.empty();
    }

    @Override
    public Order setId(String id) {
        this.uuid = UUID.fromString(id);
        return this;
    }
}
