package com.kodilla.good.patterns.challenges.entity;

import com.kodilla.good.patterns.challenges.infrastructure.entity.AbstractEntity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.CascadeType;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Entity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Id;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.OneToOne;
import com.kodilla.good.patterns.challenges.repository.OrderPositionRepository;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
@Entity(repository = OrderPositionRepository.class)
public class OrderPosition extends AbstractEntity {
    @Id
    private UUID uuid;
    @NonNull
    @OneToOne(targetEntity = Product.class, cascade = CascadeType.Save)
    private Product product;
    private int count;

    public OrderPosition(@NonNull Product product, int count) {
        this.product = product;
        this.count = count;
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
}
