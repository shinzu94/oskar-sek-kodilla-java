package com.kodilla.testing.shape;

public class Quadrat implements Shape {
    private static final String NAME = "Quadrat";
    private double side;

    public Quadrat(double side) {
        this.side = side;
    }

    @Override
    public String getShapeName() {
        return NAME;
    }

    @Override
    public double getField() {
        return side * side;
    }
}
