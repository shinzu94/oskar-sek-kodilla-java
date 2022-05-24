package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;

public class WeatherForecast {
    private final Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public OptionalDouble calculateAverageTemperatureForecast() {
        Map<String, Double> map = calculateForecast();
        return map.values().stream().mapToDouble(v -> v).average();
    }

    public OptionalDouble calculateMedianTemperatureForecast() {
        Map<String, Double> map = calculateForecast();
        int size = map.size();
        if (size > 0) {
            double[] array = map.values().stream().mapToDouble(v -> v).sorted().toArray();

            int halfSize = size / 2;
            if (size % 2 == 1) {
                return OptionalDouble.of(array[halfSize]);
            } else {
                return OptionalDouble.of(((array[halfSize - 1] + array[halfSize]) / 2));
            }
        }
        return OptionalDouble.empty();
    }
}