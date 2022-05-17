package com.kodilla.testing.weather.stub;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {
    private static final Map<String, Double> TEMPERATURE_EMPTY_MAP = Collections.unmodifiableMap(new HashMap<>());
    private static Map<String, Double> exampleTemperatureMap;
    @Mock
    private Temperatures temperaturesMock;

    @BeforeAll
    static void beforeAll() {
        exampleTemperatureMap = new HashMap<>();
        exampleTemperatureMap.put("Rzeszow", 25.5);
        exampleTemperatureMap.put("Krakow", 26.2);
        exampleTemperatureMap.put("Wroclaw", 24.8);
        exampleTemperatureMap.put("Warszawa", 25.2);
        exampleTemperatureMap.put("Gdansk", 26.1);
    }

    @Test
    void testCalculateForecastWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        when(temperaturesMock.getTemperatures()).thenReturn(exampleTemperatureMap);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAverageTemperatureForEmptyForecast() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        when(temperaturesMock.getTemperatures()).thenReturn(TEMPERATURE_EMPTY_MAP);

        //When
        OptionalDouble result = weatherForecast.calculateAverageTemperatureForecast();

        //Then
        assertFalse(result.isPresent());
    }

    @Test
    void testCalculateAverageTemperatureForecast() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        when(temperaturesMock.getTemperatures()).thenReturn(exampleTemperatureMap);

        //When
        OptionalDouble result = weatherForecast.calculateAverageTemperatureForecast();

        //Then
        assertTrue(result.isPresent());
        assertEquals(26.56, Math.round(result.getAsDouble() * 100) / 100D);
    }

    @Test
    void testCalculateMedianTemperatureForEmptyForecast() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        when(temperaturesMock.getTemperatures()).thenReturn(TEMPERATURE_EMPTY_MAP);

        //When
        OptionalDouble result = weatherForecast.calculateMedianTemperatureForecast();

        //Then
        assertFalse(result.isPresent());
    }

    @Test
    void testCalculateMedianTemperatureForecast() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        when(temperaturesMock.getTemperatures()).thenReturn(exampleTemperatureMap);

        //When
        OptionalDouble result = weatherForecast.calculateMedianTemperatureForecast();

        //Then
        assertTrue(result.isPresent());
        assertEquals(26.5, Math.round(result.getAsDouble() * 100) / 100D);
    }

    @Test
    void testCalculateMedianTemperatureForecastWithEvenLength() {
        //Given
        Map<String, Double> temperatureMapWithEvenLength = new HashMap<>();
        temperatureMapWithEvenLength.put("Rzeszow", 25.5);
        temperatureMapWithEvenLength.put("Krakow", 26.2);
        temperatureMapWithEvenLength.put("Wroclaw", 24.8);
        temperatureMapWithEvenLength.put("Warszawa", 25.2);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        when(temperaturesMock.getTemperatures()).thenReturn(temperatureMapWithEvenLength);

        //When
        OptionalDouble result = weatherForecast.calculateMedianTemperatureForecast();

        //Then
        assertTrue(result.isPresent());
        assertEquals(26.35, Math.round(result.getAsDouble() * 100) / 100D);
    }
}