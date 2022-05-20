package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Collection;

public class World {
    Collection<Continent> continents;

    public World(Collection<Continent> continents) {
        this.continents = continents;
    }

    BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}