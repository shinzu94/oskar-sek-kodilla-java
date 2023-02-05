package com.kodilla.good.patterns.challenges.flights.repository;

import com.kodilla.good.patterns.challenges.flights.model.Airport;
import com.kodilla.good.patterns.challenges.flights.model.Flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class FlightRepository {

    private final static LocalDateTime TOMORROW = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);

    private final static ZoneId ZONE_ID = ZoneId.systemDefault();

    private final List<Flight> flightList;

    public FlightRepository() {
        flightList = List.of(
                new Flight(new Airport(Airport.CRACOW), new Airport(Airport.WARSAW), prepareTime(2, 30), prepareTime(3, 30)),
                new Flight(new Airport(Airport.CRACOW), new Airport(Airport.WROCLAW), prepareTime(2, 49), prepareTime(4, 5)),
                new Flight(new Airport(Airport.CRACOW), new Airport(Airport.GDANSK), prepareTime(4, 55), prepareTime(6, 50)),
                new Flight(new Airport(Airport.CRACOW), new Airport(Airport.WARSAW), prepareTime(4, 30), prepareTime(5, 30)),
                new Flight(new Airport(Airport.CRACOW), new Airport(Airport.WROCLAW), prepareTime(4, 49), prepareTime(6, 5)),
                new Flight(new Airport(Airport.CRACOW), new Airport(Airport.GDANSK), prepareTime(6, 55), prepareTime(8, 50)),
                new Flight(new Airport(Airport.CRACOW), new Airport(Airport.WARSAW), prepareTime(6, 30), prepareTime(7, 30)),
                new Flight(new Airport(Airport.CRACOW), new Airport(Airport.WROCLAW), prepareTime(6, 49), prepareTime(8, 5)),
                new Flight(new Airport(Airport.CRACOW), new Airport(Airport.GDANSK), prepareTime(8, 55), prepareTime(10, 50)),


                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.CRACOW), prepareTime(2, 11), prepareTime(3, 15)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.KATOWICE), prepareTime(2, 43), prepareTime(3, 47)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.GDANSK), prepareTime(2, 55), prepareTime(3, 55)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.WROCLAW), prepareTime(2, 22), prepareTime(4, 55)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.CRACOW), prepareTime(4, 11), prepareTime(5, 15)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.KATOWICE), prepareTime(4, 43), prepareTime(5, 47)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.GDANSK), prepareTime(4, 55), prepareTime(5, 55)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.WROCLAW), prepareTime(4, 22), prepareTime(6, 55)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.CRACOW), prepareTime(6, 11), prepareTime(7, 15)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.KATOWICE), prepareTime(6, 43), prepareTime(7, 47)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.GDANSK), prepareTime(6, 55), prepareTime(7, 55)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.WROCLAW), prepareTime(6, 22), prepareTime(8, 55)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.CRACOW), prepareTime(8, 11), prepareTime(9, 15)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.KATOWICE), prepareTime(8, 43), prepareTime(9, 47)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.GDANSK), prepareTime(8, 55), prepareTime(9, 55)),
                new Flight(new Airport(Airport.WARSAW), new Airport(Airport.WROCLAW), prepareTime(8, 22), prepareTime(10, 55))
//                ,
//
//
//
//
//                new Flight(Airport.CRACOW, Airport.WARSAW, prepareTime(2, 30), prepareTime(3, 30)),
//                new Flight(Airport.CRACOW, Airport.WARSAW, prepareTime(2, 30), prepareTime(3, 30)),
//                new Flight(Airport.CRACOW, Airport.WARSAW, prepareTime(2, 30), prepareTime(3, 30)),
//                new Flight(Airport.CRACOW, Airport.WARSAW, prepareTime(2, 30), prepareTime(3, 30)),
//                new Flight(Airport.CRACOW, Airport.WARSAW, prepareTime(2, 30), prepareTime(3, 30)),
//                new Flight(Airport.CRACOW, Airport.WARSAW, prepareTime(2, 30), prepareTime(3, 30)),
//                new Flight(Airport.CRACOW, Airport.WARSAW, prepareTime(2, 30), prepareTime(3, 30))
        );
    }

    private ZonedDateTime prepareTime(Integer hours, Integer minutes) {
        return ZonedDateTime.of(TOMORROW, ZONE_ID).plusHours(hours).plusMinutes(minutes);
    }

    public List<Flight> getFlightList() {
        return List.copyOf(flightList);
    }
}
