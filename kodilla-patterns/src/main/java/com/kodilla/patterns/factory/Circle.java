package com.kodilla.patterns.factory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Circle implements Shape {
    @Getter
    private final String name;
    private final double radius;

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2.0);
    }

    @Override
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
