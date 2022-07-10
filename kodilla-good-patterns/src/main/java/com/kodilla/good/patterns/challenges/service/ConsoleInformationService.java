package com.kodilla.good.patterns.challenges.service;

public class ConsoleInformationService implements InformationServiceInterface {
    @Override
    public void inform(String message) {
        System.out.println(message);
    }
}
