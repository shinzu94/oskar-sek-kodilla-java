package com.kodilla.patterns.strategy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Customer {
    private final String name;
    protected BuyPredictor buyPredictor;

    public String predict() {
        return buyPredictor.predictWhatToBuy();
    }

    public Customer setBuyingStrategy(BuyPredictor buyPredictor) {
        this.buyPredictor = buyPredictor;
        return this;
    }
}
