package com.kodilla.testing.shape;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class ShapeCollectorTestSuite {
    private static final Shape triangle = new Triangle(5, 4, 7);
    private static final Shape disk = new Disk(5);
    private static final Shape quadrat = new Quadrat(5);
    private static final Shape disk2 = new Disk(9);
    private final ShapeCollector shapeCollector = new ShapeCollector();

    @DisplayName("Tests of adding shapes")
    @Nested
    class TestAddingShapes {
        @DisplayName("Add one shape and get figure should return added shape and show figure should return name of shape")
        @Test
        void testAddOneShape() {
            //Given
            String expectedString = "Triangle";

            //When
            shapeCollector.addFigure(triangle);

            //Then
            assertEquals(triangle, shapeCollector.getFigure(0));
            assertEquals(expectedString, shapeCollector.showFigures());
        }

        @DisplayName("Add many shapes and get figure should return added shapes and show figure return should names of shapes")
        @Test
        void testAddManyShape() {
            //Given
            String expectedString = "TriangleDiskQuadratDisk";

            //When
            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(disk);
            shapeCollector.addFigure(quadrat);
            shapeCollector.addFigure(disk2);

            //Then
            assertEquals(triangle, shapeCollector.getFigure(0));
            assertEquals(disk, shapeCollector.getFigure(1));
            assertEquals(quadrat, shapeCollector.getFigure(2));
            assertEquals(disk2, shapeCollector.getFigure(3));
            assertEquals(expectedString, shapeCollector.showFigures());
        }
    }

    @DisplayName("Tests of removing shapes")
    @Nested
    class TestRemoveShapes {
        @DisplayName("Remove one and only shape and show figure should return empty string")
        @Test
        void testRemoveOneAndOnlyShape() {
            //Given
            String expectedString = "";
            shapeCollector.addFigure(triangle);

            //When
            shapeCollector.removeFigure(triangle);

            //Then
            assertEquals(expectedString, shapeCollector.showFigures());
        }

        @DisplayName("Remove first shape from twp and show figure 0 should return previously second shape")
        @Test
        void testRemoveFirstShapeFromTwo() {
            //Given
            String expectedString = "Disk";
            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(disk);

            //When
            shapeCollector.removeFigure(triangle);

            //Then
            assertEquals(disk, shapeCollector.getFigure(0));
            assertEquals(expectedString, shapeCollector.showFigures());
        }

        @DisplayName("Remove last shape from two and showFigures should return only name of first element")
        @Test
        void testRemoveNotLastShape() {
            //Given
            String expectedString = "Triangle";
            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(disk);

            //When
            shapeCollector.removeFigure(disk);

            //Then
            assertEquals(expectedString, shapeCollector.showFigures());
        }

        @DisplayName("Remove not existing element and showFigures should return names of all elements")
        @Test
        void testRemoveNotExistShape() {
            //Given
            String expectedString = "Triangle";
            shapeCollector.addFigure(triangle);

            //When
            shapeCollector.removeFigure(disk);

            //Then
            assertEquals(expectedString, shapeCollector.showFigures());
        }
    }

    @DisplayName("Tests of show shapes")
    @Nested
    class TestShowShapes {
        @DisplayName("For empty shapes show figure should return empty string")
        @Test
        void testShowFiguresEmptyShapes() {
            //Given
            String expectedString = "";

            //When
            String result = shapeCollector.showFigures();

            //Then
            assertEquals(expectedString, result);
        }

        @DisplayName("For four shapes show figure should return string with names in order")
        @Test
        void testShowFiguresShape() {
            //Given
            String expectedString = "TriangleDiskQuadratDisk";
            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(disk);
            shapeCollector.addFigure(quadrat);
            shapeCollector.addFigure(disk2);

            //When
            String result = shapeCollector.showFigures();

            //Then
            assertEquals(expectedString, result);
        }
    }


    @DisplayName("Tests of show shapes")
    @Nested
    class TestGetShapes {
        @DisplayName("For empty shapes get should throw exception")
        @Test
        void testGetFiguresFromEmptyShapes() {
            //Given
            Throwable exception = null;

            //When
            try {
                shapeCollector.getFigure(0);
            } catch (Throwable throwable) {
                exception = throwable;
            }

            //Then
            assertNotNull(exception);
        }

        @DisplayName("For four shapes get should return in order of adding")
        @Test
        void testGetFiguresFromShapes() {
            //Given
            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(disk);
            shapeCollector.addFigure(quadrat);
            shapeCollector.addFigure(disk2);

            //When
            Shape result0 = shapeCollector.getFigure(0);
            Shape result1 = shapeCollector.getFigure(1);
            Shape result2 = shapeCollector.getFigure(2);
            Shape result3 = shapeCollector.getFigure(3);

            //Then
            assertEquals(triangle, result0);
            assertEquals(disk, result1);
            assertEquals(quadrat, result2);
            assertEquals(disk2, result3);
        }
    }
}
