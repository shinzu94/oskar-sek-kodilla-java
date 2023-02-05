package com.kodilla.good.patterns.challenges.food2door.domain.order.model;

import com.kodilla.good.patterns.challenges.food2door.domain.product.Product;
import lombok.Value;

import java.util.Map;

@Value
public class OrderRequest {
    Map<Product, Integer> productOrderList;
}
