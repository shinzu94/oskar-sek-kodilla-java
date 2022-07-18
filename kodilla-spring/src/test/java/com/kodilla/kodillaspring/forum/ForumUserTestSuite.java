package com.kodilla.kodillaspring.forum;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForumUserTestSuite {
    @Test
    void testGetUsername() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.kodillaspring");
        ForumUser user = context.getBean(ForumUser.class);

        String username = user.getUsername();

        assertEquals("John Smith", username);
    }
}
