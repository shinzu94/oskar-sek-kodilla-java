package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

abstract public class AbstractPizzaSizeOrderDecorator implements PizzaWithSizeOrder {
    private final PizzaWithoutSizeOrder pizzaOrder;

    protected AbstractPizzaSizeOrderDecorator(PizzaWithoutSizeOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getCost() {
        return pizzaOrder.getCost();
    }

    public String getDescription() {
        return "Order a pizza size " + getPizzaSize();
    }
}
