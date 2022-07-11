package com.kodilla.good.patterns.challenges.model;

import com.kodilla.good.patterns.challenges.entity.OrderPosition;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class OrderRequest {
    @NonNull
    User user;
    @NonNull
    List<OrderPosition> ordersPositions;
    @NonNull
    String address;
    @NonNull
    LocalDateTime orderDateTime;
}
