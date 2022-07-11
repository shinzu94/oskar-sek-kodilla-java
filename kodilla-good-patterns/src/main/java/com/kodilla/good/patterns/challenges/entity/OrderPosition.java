package com.kodilla.good.patterns.challenges.entity;

import com.kodilla.good.patterns.challenges.infrastructure.entity.AbstractEntity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Entity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Id;
import com.kodilla.good.patterns.challenges.repository.EntityRepositoryInterface;
import com.kodilla.good.patterns.challenges.repository.OrderPositionRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor()
@RequiredArgsConstructor
@Entity(repository = OrderPositionRepository.class)
public class OrderPosition extends AbstractEntity {
    protected static Map<String, String> relations = new HashMap<>();
    @Id
    private UUID uuid;
    @NonNull
    private Product product;
    @NonNull
    private int count;

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
    public Class<? extends EntityRepositoryInterface> getRepositoryClass() {
        return OrderPositionRepository.class;
    }
}
