package com.kodilla.good.patterns.challenges.flights.model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Flight {
    String from;
    String to;
    LocalDateTime begin;
    LocalDateTime end;
}
