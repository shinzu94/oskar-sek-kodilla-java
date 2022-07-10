package com.kodilla.good.patterns.challenges.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Product implements EntityInterface {
    protected static Map<String, String> relations = new HashMap<>();
    private UUID uuid;
    @NonNull
    private String name;
    @NonNull
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (uuid != null ? !uuid.equals(product.uuid) : product.uuid != null) return false;
        if (!name.equals(product.name)) return false;
        return price.equals(product.price);
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public Optional<String> getId() {
        return uuid != null ? Optional.of(uuid.toString()) : Optional.empty();
    }

    @Override
    public Product setId(String id) {
        this.uuid = UUID.fromString(id);
        return this;
    }
}
