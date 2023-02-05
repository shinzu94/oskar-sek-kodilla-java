package com.kodilla.good.patterns.challenges.food2door.domain.producer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProductAvailability {

    private Double units;

    private Double price;
}
