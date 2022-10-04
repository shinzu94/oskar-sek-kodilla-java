package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaSizeSOrderDecorator extends AbstractPizzaSizeOrderDecorator {
    protected PizzaSizeSOrderDecorator(PizzaWithoutSizeOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return BigDecimal.valueOf(10);
    }

    @Override
    public PizzaSize getPizzaSize() {
        return PizzaSize.S;
    }
}
