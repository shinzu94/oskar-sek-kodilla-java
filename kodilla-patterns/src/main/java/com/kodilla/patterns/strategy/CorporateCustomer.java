package com.kodilla.patterns.strategy;


import com.kodilla.patterns.strategy.predictors.BalancedPredictor;

public class CorporateCustomer extends Customer {
    public CorporateCustomer(String name) {
        super(name);
        buyPredictor = new BalancedPredictor();
    }
}
