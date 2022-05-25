package com.kodilla.exception.nullpointer;

public class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getUsername() {
        return name;
    }
}