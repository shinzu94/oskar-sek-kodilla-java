package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaWithoutSizeOrder {
    @Override
    public BigDecimal getCost() {
        return BigDecimal.ZERO;
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public PizzaSize getPizzaSize() {
        return null;
    }
}
