package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {
    @Test
    void testBigmacBuilder() {
        //GIVEN
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.WITH_SESAME)
                .burgers(2)
                .sauce(Sauce.THOUSAND_ISLAND)
                .ingredient(Ingredients.BACON)
                .ingredient(Ingredients.CHEESE)
                .ingredient(Ingredients.LETTUCE)
                .build();

        //WHEN
        Bun bun = bigmac.getBun();
        int burgers = bigmac.getBurgers();
        Sauce sauce = bigmac.getSauce();
        List<Ingredients> ingredients = bigmac.getIngredients();

        //THEN
        assertEquals(Bun.WITH_SESAME, bun);
        assertEquals(2, burgers);
        assertEquals(Sauce.THOUSAND_ISLAND, sauce);
        assertEquals(List.of(Ingredients.BACON, Ingredients.CHEESE, Ingredients.LETTUCE), ingredients);
    }
}
