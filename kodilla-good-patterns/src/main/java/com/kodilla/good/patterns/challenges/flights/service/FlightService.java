package com.kodilla.good.patterns.challenges.flights.service;

import com.kodilla.good.patterns.challenges.flights.model.Airport;
import com.kodilla.good.patterns.challenges.flights.model.Flight;
import com.kodilla.good.patterns.challenges.flights.repository.FlightRepository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightService {

    private final static FlightRepository FLIGHT_REPOSITORY = new FlightRepository();

    public List<List<Flight>> findFlights(Airport from, Airport to) {
        List<Flight> flights = FLIGHT_REPOSITORY.getFlightList();
        List<List<Flight>> resultFlights = new LinkedList<>();
        Map<Airport, List<Flight>> potentialStopoverAirportFlight = new HashMap<>();

        findDirectFlight(flights, from, to).stream()
                .map(List::of)
                .forEach(resultFlights::add);

        findPotentialStopOverPort(flights, from, to).stream()
                .forEach(airport -> potentialStopoverAirportFlight.put(airport, new LinkedList<>()));

        flights.stream()
                .filter(flight -> flight.getTo().equals(to))
                .filter(flight -> potentialStopoverAirportFlight.containsKey(flight.getFrom()))
                .forEach(flight -> potentialStopoverAirportFlight.get(flight.getFrom()).add(flight));

        flights.stream()
                .filter(flight -> !(flight.getFrom().equals(from) && flight.getTo().equals(to)))
                .filter(flight -> flight.getFrom().equals(from) && potentialStopoverAirportFlight.containsKey(flight.getTo()))
                .forEach(flight ->
                        selectPotentialSecondFlight(potentialStopoverAirportFlight, to, flight)
                                .ifPresent(potentialFlight -> resultFlights.add(List.of(flight, potentialFlight)))
                );

        return resultFlights;
    }

    private Optional<Flight> selectPotentialSecondFlight(Map<Airport, List<Flight>> potentialStopoverAirportFlight, Airport to, Flight firstFlight) {
        return potentialStopoverAirportFlight.get(firstFlight.getTo()).stream()
                .filter(potentialStopoverFlight -> potentialStopoverFlight.getTo().equals(to))
                .filter(potentialStopoverFlight -> potentialStopoverFlight.getBegin().isAfter(firstFlight.getBegin()))
                .sorted((o1, o2) -> o1.getBegin().isBefore(o2.getBegin()) ? -1 : o1.getBegin().equals(o2.getBegin()) ? 0 : 1)
                .findFirst();
    }

    private Set<Airport> findPotentialStopOverPort(List<Flight> flights, Airport from, Airport to) {
        return flights.stream()
                .filter(flight -> !(flight.getFrom().equals(from) && flight.getTo().equals(to)))
                .filter(flight -> flight.getFrom().equals(from))
                .map(Flight::getTo)
                .collect(Collectors.toSet());
    }

    private List<Flight> findDirectFlight(List<Flight> flights, Airport from, Airport to) {
        return flights.stream().filter(flight -> flight.getFrom().equals(from) && flight.getTo().equals(to)).collect(Collectors.toList());
    }

    public List<Flight> findFlightFromAirport(Airport airport) {
        return FLIGHT_REPOSITORY.getFlightList().stream().filter(flight -> flight.getFrom().equals(airport)).collect(Collectors.toList());
    }

    public List<Flight> findFlightToAirport(Airport airport) {
        return FLIGHT_REPOSITORY.getFlightList().stream().filter(flight -> flight.getTo().equals(airport)).collect(Collectors.toList());
    }
}
