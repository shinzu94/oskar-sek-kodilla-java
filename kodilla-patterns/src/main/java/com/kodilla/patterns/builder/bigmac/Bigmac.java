package com.kodilla.patterns.builder.bigmac;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Bigmac {
    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredients> ingredients;

    public Bigmac(Bun bun, int burgers, Sauce sauce, List<Ingredients> ingredients) {
        this.bun = bun;
        this.sauce = sauce;
        this.burgers = burgers;
        this.ingredients = ingredients;
    }

    public static class BigmacBuilder {
        private final List<Ingredients> ingredients = new ArrayList<>();
        private Bun bun;
        private int burgers = 0;
        private Sauce sauce;

        public BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            if (burgers > 3) {
                throw new IllegalStateException("You can't get more than 3 burgers.");
            }
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(Ingredients ingredient) {
            ingredients.add(ingredient);
            if (ingredients.size() > 10) {
                throw new IllegalStateException("You can't get more than 10 ingredients.");
            }
            return this;
        }

        public Bigmac build() {
            if (bun == null) {
                throw new IllegalStateException("You need choice bun.");
            }
            if (sauce == null) {
                throw new IllegalStateException("You need choice sauce.");
            }
            if (burgers <= 0) {
                throw new IllegalStateException("You need get more than 0 burgers.");
            }
            if (ingredients.size() == 0) {
                throw new IllegalStateException("You need choice more than 0 ingredients.");
            }
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }
}
