package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaSizeXLOrderDecorator extends AbstractPizzaSizeOrderDecorator {
    protected PizzaSizeXLOrderDecorator(PizzaWithoutSizeOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return BigDecimal.valueOf(20);
    }

    @Override
    public PizzaSize getPizzaSize() {
        return PizzaSize.XL;
    }
}
