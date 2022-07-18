package com.kodilla.kodillaspring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTestSuite {
    @Test
    void testCalculations() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.kodillaspring");
        Calculator calculator = context.getBean(Calculator.class);
        double firstNumber = 2;
        double secondNumber = -3;

        double sum = calculator.add(firstNumber, secondNumber);
        double diff = calculator.sub(firstNumber, secondNumber);
        double mul = calculator.mul(firstNumber, secondNumber);
        double div = calculator.div(firstNumber, secondNumber);

        assertEquals(-1, sum);
        assertEquals(5, diff);
        assertEquals(-6, mul);
        assertEquals(-0.66, div, 2);
    }
}
