package com.kodilla.exception.test;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeFileReaderTestSuite {

    @Test
    void whenArgumentsIsIncorrectShouldThrowException() {
        // given
        SecondChallenge SecondChallenge = new SecondChallenge();
        // when & then
        assertAll(
                () -> assertThrows(Exception.class, () -> SecondChallenge.probablyIWillThrowException(1.5, 1.5)),
                () -> assertDoesNotThrow(() -> SecondChallenge.probablyIWillThrowException(1.5, 1)),
                () -> assertThrows(Exception.class, () -> SecondChallenge.probablyIWillThrowException(2, 5)),
                () -> assertThrows(Exception.class, () -> SecondChallenge.probablyIWillThrowException(3, 3)),
                () -> assertThrows(Exception.class, () -> SecondChallenge.probablyIWillThrowException(0.99, 9)),
                () -> assertThrows(Exception.class, () -> SecondChallenge.probablyIWillThrowException(0, -6)),
                () -> assertDoesNotThrow(() -> SecondChallenge.probablyIWillThrowException(1, 1)),
                () -> assertThrows(Exception.class, () -> SecondChallenge.probablyIWillThrowException(2, 1.5))
        );
    }
}
