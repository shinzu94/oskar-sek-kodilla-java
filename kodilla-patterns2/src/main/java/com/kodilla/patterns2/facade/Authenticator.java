package com.kodilla.patterns2.facade;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Authenticator {
    public boolean isAuthenticated(Long userId) {
        Random random = new Random();
        return random.nextBoolean();
    }
}
