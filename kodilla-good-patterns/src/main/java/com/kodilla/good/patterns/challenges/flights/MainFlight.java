package com.kodilla.good.patterns.challenges.flights;

import com.kodilla.good.patterns.challenges.flights.model.Airport;
import com.kodilla.good.patterns.challenges.flights.model.Flight;
import com.kodilla.good.patterns.challenges.flights.service.FlightService;

import java.util.List;

public class MainFlight {
    public static void main(String[] args) {
        FlightService flightService = new FlightService();
        Airport from = new Airport(Airport.CRACOW);
        Airport to = new Airport(Airport.GDANSK);

        System.out.printf("findFlightFromAirport %s%n", from.getName());
        List<Flight> f1 = flightService.findFlightFromAirport(from);
        f1.stream().forEach(System.out::println);

        System.out.printf("\nfindFlightToAirport %s%n", to.getName());
        List<Flight> f2 = flightService.findFlightToAirport(to);
        f2.stream().forEach(System.out::println);

        System.out.printf("\nfindFlights %s -> %s%n", from.getName(), to.getName());
        List<List<Flight>> f3 = flightService.findFlights(from, to);
        for (List<Flight> flights : f3) {
            System.out.println(flights.size() > 1 ? "Flight with overport" : "DirectFlight");
            flights.forEach(System.out::println);
            System.out.println();
        }
    }
}
