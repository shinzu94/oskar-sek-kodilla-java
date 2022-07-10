package com.kodilla.good.patterns.challenges.model;

import lombok.Value;

@Value
public class OrderProcessDto {
    User user;
    boolean isOrdered;
}
