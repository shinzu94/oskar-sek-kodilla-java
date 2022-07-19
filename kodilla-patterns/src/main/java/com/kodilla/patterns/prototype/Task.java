package com.kodilla.patterns.prototype;

import lombok.Value;

@Value
public class Task {
    String name;

    @Override
    public String toString() {
        return "      Task [" + name + "]";
    }
}