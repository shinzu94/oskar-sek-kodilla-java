package com.kodilla.patterns.strategy.social;


import com.kodilla.patterns.strategy.social.publisher.TwitterPublisher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testDefaultSharingStrategies() {
        //GIVEN
        User millenialsUser = new Millenials("Jan");
        User yGenerationUser = new YGeneration("Tomasz");
        User zGenerationUser = new ZGeneration("Tomasz");

        //WHEN
        millenialsUser.sharePost();
        String millenialsUserShare = outputStreamCaptor.toString().trim();
        outputStreamCaptor.reset();

        yGenerationUser.sharePost();
        String yGenerationUserShare = outputStreamCaptor.toString().trim();
        outputStreamCaptor.reset();

        zGenerationUser.sharePost();
        String zGenerationUserShare = outputStreamCaptor.toString().trim();

        //THEN
        assertEquals("Facebook", millenialsUserShare);
        assertEquals("Twitter", yGenerationUserShare);
        assertEquals("Snapchat", zGenerationUserShare);
    }

    @Test
    void testIndividualSharingStrategy() {
        //GIVEN
        User millenialsUser = new Millenials("Jan");

        //WHEN
        millenialsUser.setPreferredSocialPublisher(new TwitterPublisher());
        millenialsUser.sharePost();
        String millenialsUserShare = outputStreamCaptor.toString().trim();

        //THEN
        assertEquals("Twitter", millenialsUserShare);
    }
}
