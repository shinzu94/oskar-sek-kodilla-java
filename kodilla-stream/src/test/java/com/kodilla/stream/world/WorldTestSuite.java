package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        World world = prepareEuropeWorld();

        //When
        BigDecimal quantity = world.getPeopleQuantity();

        //Then
        assertEquals(new BigDecimal("4058662079"), quantity);
    }

    private World prepareEuropeWorld() {
        Set<Continent> continents = new HashSet<>();
        continents.add(prepareEurope());
        continents.add(prepareAfrica());
        continents.add(prepareAsia());
        continents.add(prepareAustralia());
        continents.add(prepareNorthAmerica());
        continents.add(prepareSouthAmerica());
        return new World(continents);
    }

    private Continent prepareEurope() {
        Country poland = new Country(new BigDecimal("38000000"));
        Country german = new Country(new BigDecimal("68000000"));
        Country france = new Country(new BigDecimal("50000000"));
        Country spain = new Country(new BigDecimal("20000000"));
        Country italy = new Country(new BigDecimal("40000000"));
        List<Country> countries = new ArrayList<>();
        countries.add(poland);
        countries.add(german);
        countries.add(france);
        countries.add(spain);
        countries.add(italy);
        return new Continent(countries);
    }

    private Continent prepareAfrica() {
        Country cameroon = new Country(new BigDecimal("26500000"));
        Country egypt = new Country(new BigDecimal("102000000"));
        Country southAfrica = new Country(new BigDecimal("60142000"));
        List<Country> countries = new ArrayList<>();
        countries.add(cameroon);
        countries.add(egypt);
        countries.add(southAfrica);
        return new Continent(countries);
    }

    private Continent prepareAsia() {
        Country china = new Country(new BigDecimal("1412600000"));
        Country japan = new Country(new BigDecimal("125502000"));
        Country india = new Country(new BigDecimal("1352642280"));
        List<Country> countries = new ArrayList<>();
        countries.add(china);
        countries.add(japan);
        countries.add(india);
        return new Continent(countries);
    }

    private Continent prepareAustralia() {
        Country australia = new Country(new BigDecimal("7692024"));
        List<Country> countries = new ArrayList<>();
        countries.add(australia);
        return new Continent(countries);
    }

    private Continent prepareNorthAmerica() {
        Country usa = new Country(new BigDecimal("331893745"));
        Country canada = new Country(new BigDecimal("38526760"));
        Country mexico = new Country(new BigDecimal("126014024"));
        List<Country> countries = new ArrayList<>();
        countries.add(usa);
        countries.add(canada);
        countries.add(mexico);
        return new Continent(countries);
    }

    private Continent prepareSouthAmerica() {
        Country brazil = new Country(new BigDecimal("212688125"));
        Country venezuela = new Country(new BigDecimal("28887118"));
        Country chile = new Country(new BigDecimal("17574003"));
        List<Country> countries = new ArrayList<>();
        countries.add(brazil);
        countries.add(venezuela);
        countries.add(chile);
        return new Continent(countries);
    }
}