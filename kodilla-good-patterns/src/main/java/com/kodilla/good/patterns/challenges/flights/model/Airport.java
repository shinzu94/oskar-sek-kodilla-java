package com.kodilla.good.patterns.challenges.flights.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Airport {

    public final static String CRACOW = "Cracow";

    public final static String GDANSK = "Gdańsk";

    public final static String KATOWICE = "Katowice";

    public final static String WROCLAW = "Wroclaw";

    public final static String WARSAW = "Warsaw";

    private final String name;

    public Airport(String name) {
        this.name = name;
    }
}
