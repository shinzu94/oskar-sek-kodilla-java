package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testSizeLHawaiiPizzaCost() {
        // Given
        PizzaWithSizeOrder hawaiiPizza = prepareSizeLHawaiiPizza();
        // When
        BigDecimal calculatedCost = hawaiiPizza.getCost();
        // Then
        assertEquals(new BigDecimal("26").doubleValue(), calculatedCost.doubleValue(), 4);
    }


    @Test
    public void testSizeLHawaiiPizzaDescription() {
        // Given
        PizzaWithSizeOrder hawaiiPizza = prepareSizeLHawaiiPizza();
        // When
        String description = hawaiiPizza.getDescription();
        // Then
        assertEquals("Order a pizza size L + Pineapple + Ham + Cheese", description);
    }

    private PizzaWithSizeOrder prepareSizeLHawaiiPizza() {
        PizzaWithoutSizeOrder theOrder = new BasicPizzaOrder();

        PizzaWithSizeOrder theOrderWithSize = new PizzaSizeLOrderDecorator(theOrder);
        theOrderWithSize = new PineappleIngredientDecorator(theOrderWithSize);
        theOrderWithSize = new HamIngredientDecorator(theOrderWithSize);
        theOrderWithSize = new CheeseIngredientDecorator(theOrderWithSize);
        return theOrderWithSize;
    }
}
