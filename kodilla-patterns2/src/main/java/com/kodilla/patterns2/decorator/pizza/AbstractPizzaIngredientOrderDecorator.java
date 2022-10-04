package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

abstract public class AbstractPizzaIngredientOrderDecorator implements PizzaWithSizeOrder {
    private final PizzaWithSizeOrder pizzaOrder;

    protected AbstractPizzaIngredientOrderDecorator(PizzaWithSizeOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getCost() {
        return pizzaOrder.getCost();
    }

    @Override
    public String getDescription() {
        return pizzaOrder.getDescription();
    }

    @Override
    public PizzaSize getPizzaSize() {
        return pizzaOrder.getPizzaSize();
    }
}