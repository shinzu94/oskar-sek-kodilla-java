package com.kodilla.patterns.factory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Rectangle implements Shape {
    @Getter
    private final String name;
    private final double width;
    private final double length;

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getCircumference() {
        return 2 * width + 2 * length;
    }
}
