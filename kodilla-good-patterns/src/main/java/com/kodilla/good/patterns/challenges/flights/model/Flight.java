package com.kodilla.good.patterns.challenges.flights.model;

import lombok.Value;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Value
public class Flight {

    Airport from;

    Airport to;

    ZonedDateTime begin;

    ZonedDateTime end;

    @Override
    public String toString() {
        return "Flight " +
                "from: " + from.getName() +
                ", to: " + to.getName() +
                ", begin: " + begin.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) +
                ", end: " + end.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
