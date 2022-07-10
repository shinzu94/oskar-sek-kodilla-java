package com.kodilla.good.patterns.challenges.model;

import lombok.Value;

@Value
public class User {
    String name;
    String surname;

    public String getFullName() {
        return name + " " + surname;
    }
}
