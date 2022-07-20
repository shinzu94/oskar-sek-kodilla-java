package com.kodilla.patterns.factory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Square implements Shape {
    @Getter
    private final String name;
    private final double width;

    @Override
    public double getArea() {
        return Math.pow(width, 2.0);
    }

    @Override
    public double getCircumference() {
        return 4 * width;
    }
}
