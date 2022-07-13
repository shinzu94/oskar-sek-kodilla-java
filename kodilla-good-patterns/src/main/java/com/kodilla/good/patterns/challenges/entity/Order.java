package com.kodilla.good.patterns.challenges.entity;

import com.kodilla.good.patterns.challenges.infrastructure.entity.AbstractEntity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.CascadeType;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Entity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Id;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.OneToMany;
import com.kodilla.good.patterns.challenges.repository.OrderRepository;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity(repository = OrderRepository.class)
public class Order extends AbstractEntity {
    @Id
    @EqualsAndHashCode.Include
    private UUID uuid;
    @NonNull
    @OneToMany(targetEntity = OrderPosition.class, cascade = CascadeType.SAVE)
    private List<OrderPosition> orderPositions;
    @NonNull
    private String address;

    public void addPosition(OrderPosition orderPosition) {
        orderPositions.add(orderPosition);
    }
}
