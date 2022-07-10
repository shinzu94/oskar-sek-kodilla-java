package com.kodilla.good.patterns.challenges.model;

import com.kodilla.good.patterns.challenges.entity.OrderPosition;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class OrderRequest {
    User user;
    List<OrderPosition> ordersPositions;
    String address;
    LocalDateTime orderDateTime;
}
