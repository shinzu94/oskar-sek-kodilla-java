package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    public static boolean findFlight(Flight flight) throws RouteNotFoundException {
        final Map<String, Boolean> flightsMap = new HashMap<>();
        flightsMap.put("Warsaw", true);
        flightsMap.put("Berlin", false);

        if (!flightsMap.containsKey(flight.getDepartureAirport()) || !flightsMap.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException(
                    "We don't handle flight from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport() + "."
            );
        }

        return flightsMap.get(flight.getDepartureAirport())
                && flightsMap.get(flight.getArrivalAirport());
    }
}