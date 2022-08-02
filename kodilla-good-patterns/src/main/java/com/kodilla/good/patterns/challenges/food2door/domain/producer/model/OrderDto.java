package com.kodilla.good.patterns.challenges.food2door.domain.producer.model;

import com.kodilla.good.patterns.challenges.food2door.domain.producer.entity.producerinfo.ProducerInfo;
import lombok.Value;

@Value
public class OrderDto {
    boolean success;
    ProducerInfo producer;
}
