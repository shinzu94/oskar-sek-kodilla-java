package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("CollectionTestSuite Test Suite")
public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Collection Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Collection Test Case: end");
    }

    @DisplayName("when give Empty List, " +
            "then OddNumbersExterminator should return Empty List"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> integersList = new ArrayList<>();
        List<Integer> expectedResult = new ArrayList<>();

        //When
        List<Integer> result = OddNumbersExterminator.exterminate(integersList);

        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("when give List with odds and evens, " +
            "then OddNumbersExterminator should return List with odds"
    )
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        List<Integer> integersList = Arrays.asList(new Integer[]{-2, -1, 0, 1, 2, 3, 4});
        List<Integer> expectedResult = Arrays.asList(new Integer[]{-2, 0, 2, 4});

        //When
        List<Integer> result = OddNumbersExterminator.exterminate(integersList);

        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}
