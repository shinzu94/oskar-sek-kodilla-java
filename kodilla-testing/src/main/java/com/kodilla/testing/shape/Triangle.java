package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private static final String NAME = "Triangle";
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public String getShapeName() {
        return NAME;
    }

    @Override
    public double getField() {
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) + (p - sideB) + (p - sideC));
    }
}
