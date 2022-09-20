package com.kodilla.testing.shape;

public class Disk implements Shape {
    private static final String NAME = "Disk";
    private final double radius;

    public Disk(double radius) {
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return NAME;
    }

    @Override
    public double getField() {
        return radius * radius * Math.PI;
    }
}
