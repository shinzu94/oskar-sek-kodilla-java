package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaSizeLOrderDecorator extends AbstractPizzaSizeOrderDecorator {
    protected PizzaSizeLOrderDecorator(PizzaWithoutSizeOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return BigDecimal.valueOf(17);
    }

    @Override
    public PizzaSize getPizzaSize() {
        return PizzaSize.L;
    }
}
