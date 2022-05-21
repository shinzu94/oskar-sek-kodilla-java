package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage() {
        //Given
        int[] array = new int[]{5, 6, 7, 8, 9, 50, 76, 104, 203, 374, 9, 5, 21, 43, 65, 12, 43, 544, 332, 999};
        //When
        double result = ArrayOperations.getAverage(array);

        //Then
        assertEquals(145.75, result, 0.005);
    }
}
