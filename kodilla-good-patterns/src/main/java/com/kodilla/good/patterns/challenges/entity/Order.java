package com.kodilla.good.patterns.challenges.entity;

import com.kodilla.good.patterns.challenges.infrastructure.entity.AbstractEntity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Entity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Id;
import com.kodilla.good.patterns.challenges.repository.EntityRepositoryInterface;
import com.kodilla.good.patterns.challenges.repository.OrderRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(repository = OrderRepository.class)
public class Order extends AbstractEntity {
    protected static Map<String, String> relations = new HashMap<>();
    @Id
    private UUID uuid;
    @NonNull
    private List<OrderPosition> orderPositions;
    @NonNull
    private String address;

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
    public Class<? extends EntityRepositoryInterface> getRepositoryClass() {
        return OrderRepository.class;
    }
}
