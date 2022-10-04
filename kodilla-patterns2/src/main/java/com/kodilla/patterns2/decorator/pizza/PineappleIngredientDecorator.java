package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PineappleIngredientDecorator extends AbstractPizzaIngredientOrderDecorator {
    private final BigDecimal S_PRICE = new BigDecimal("1");
    private final BigDecimal M_PRICE = new BigDecimal("2");
    private final BigDecimal L_PRICE = new BigDecimal("3");
    private final BigDecimal XL_PRICE = new BigDecimal("4");
    private final BigDecimal XXL_PRICE = new BigDecimal("5");
    private final Map<PizzaSize, BigDecimal> INGREDIENT_PRICES = new HashMap() {{
        put(PizzaSize.S, S_PRICE);
        put(PizzaSize.M, M_PRICE);
        put(PizzaSize.L, L_PRICE);
        put(PizzaSize.XL, XL_PRICE);
        put(PizzaSize.XXL, XXL_PRICE);
    }};

    public PineappleIngredientDecorator(PizzaWithSizeOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(INGREDIENT_PRICES.get(getPizzaSize()));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Pineapple";
    }
}
