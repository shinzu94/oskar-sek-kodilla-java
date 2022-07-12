package com.kodilla.good.patterns.challenges.service;

import com.kodilla.good.patterns.challenges.entity.OrderPosition;

import java.math.BigDecimal;

public class OrderPositionService {
    public boolean isCorrectOrderPosition(OrderPosition orderPosition) {
        return orderPosition.getCount() > 0
                && orderPosition.getProduct().getId().isPresent()
                && orderPosition.getProduct().getPrice().compareTo(BigDecimal.ZERO) == 1;
    }
}
