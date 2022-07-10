package com.kodilla.good.patterns.challenges.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class OrderPosition implements EntityInterface {
    protected static Map<String, String> relations = new HashMap<>();
    private UUID uuid;
    @NonNull
    private Product product;
    @NonNull
    private int count;

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderPosition)) return false;

        OrderPosition that = (OrderPosition) o;

        if (count != that.count) return false;
        if (!uuid.equals(that.uuid)) return false;
        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + product.hashCode();
        result = 31 * result + count;
        return result;
    }

    @Override
    public Optional<String> getId() {
        return uuid != null ? Optional.of(uuid.toString()) : Optional.empty();
    }

    @Override
    public OrderPosition setId(String id) {
        this.uuid = UUID.fromString(id);
        return this;
    }

}
