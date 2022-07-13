package com.kodilla.good.patterns.challenges.entity;

import com.kodilla.good.patterns.challenges.infrastructure.entity.AbstractEntity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.CascadeType;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Entity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Id;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.OneToOne;
import com.kodilla.good.patterns.challenges.repository.OrderPositionRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(repository = OrderPositionRepository.class)
public class OrderPosition extends AbstractEntity {
    @Id
    private UUID uuid;
    @NonNull
    @EqualsAndHashCode.Exclude
    @OneToOne(targetEntity = Product.class, cascade = CascadeType.SAVE)
    private Product product;
    private int count;

    public OrderPosition(@NonNull Product product, int count) {
        this.product = product;
        this.count = count;
    }
}
