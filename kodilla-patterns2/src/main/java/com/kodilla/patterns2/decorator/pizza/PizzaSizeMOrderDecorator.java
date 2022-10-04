package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaSizeMOrderDecorator extends AbstractPizzaSizeOrderDecorator {
    protected PizzaSizeMOrderDecorator(PizzaWithoutSizeOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return BigDecimal.valueOf(13);
    }

    @Override
    public PizzaSize getPizzaSize() {
        return PizzaSize.M;
    }
}
