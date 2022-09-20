package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        return shapes.get(n);
    }

    public String showFigures() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Shape shape : shapes) {
            stringBuilder.append(shape.getShapeName());
        }
        return stringBuilder.toString();
    }
}
