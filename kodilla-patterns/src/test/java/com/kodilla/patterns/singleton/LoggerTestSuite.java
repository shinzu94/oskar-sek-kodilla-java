package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {
    @Test
    void getLastLogShouldReturn() {
        //GIVEN
        Logger.INSTANCE.log("test");
        //WHEN
        String lastLog = Logger.INSTANCE.getLastLog();
        //THEN
        assertEquals("test", lastLog);
    }
}
