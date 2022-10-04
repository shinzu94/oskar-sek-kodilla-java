package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaSizeXXLOrderDecorator extends AbstractPizzaSizeOrderDecorator {
    protected PizzaSizeXXLOrderDecorator(PizzaWithoutSizeOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return BigDecimal.valueOf(22);
    }

    @Override
    public PizzaSize getPizzaSize() {
        return PizzaSize.XXL;
    }
}
