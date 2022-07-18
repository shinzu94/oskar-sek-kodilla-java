package com.kodilla.kodillaspring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Display {
    void displayValue(double val) {
        System.out.println(val);
    }
}
