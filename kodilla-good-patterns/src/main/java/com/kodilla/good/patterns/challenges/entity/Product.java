package com.kodilla.good.patterns.challenges.entity;

import com.kodilla.good.patterns.challenges.infrastructure.entity.AbstractEntity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Entity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Id;
import com.kodilla.good.patterns.challenges.repository.ProductRepository;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Entity(repository = ProductRepository.class)
public class Product extends AbstractEntity {
    @Id
    private UUID uuid;
    @NonNull
    private String name;
    @NonNull
    private BigDecimal price;
}
