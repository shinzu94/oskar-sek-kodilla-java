package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        simpleUserTest();

        calculatorTest();
    }

    private static void simpleUserTest() {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();
        printTestStatus(result.equals("theForumUser"));
    }

    private static void calculatorTest() {
        System.out.println("Test - pierwszy test jednostkowy:");
        calculatorAddTest();
        System.out.println("Test - drugi test jednostkowy:");
        calculatorSubtractTest();
    }

    private static void calculatorSubtractTest() {
        printTestStatus(Calculator.subtract(5, 3) == 2);
    }

    private static void calculatorAddTest() {
        printTestStatus(Calculator.add(5, 3) == 8);
    }


    private static void printTestStatus(boolean res) {
        if (res) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
    }
}