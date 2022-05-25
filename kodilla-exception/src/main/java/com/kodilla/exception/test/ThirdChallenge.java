package com.kodilla.exception.test;

public class ThirdChallenge {
    public static void main(String[] args) {
        Flight flight = new Flight("Warsaw", "Prague");
        try {
            System.out.println(FlightFinder.findFlight(flight)
                    ? "You can fly to " + flight.getArrivalAirport() + "."
                    : "You can't fly to " + flight.getArrivalAirport() + ".");
        } catch (RouteNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}