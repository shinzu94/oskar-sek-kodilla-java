package com.kodilla.exception.test;

public class ExceptionHandling {
    public void handling() {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1, 3));
        } catch (Exception e) {
            System.out.println("Undone!");
        } finally {
            System.out.println("Finally!");
        }
    }
}
