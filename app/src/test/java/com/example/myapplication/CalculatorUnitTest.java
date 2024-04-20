package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;


public class CalculatorUnitTest {

    @Test
    public void calculateBMI() {
        assertEquals(29.530996, BMICalculator.countBMI(110, 1.93f), 0.0001);
    }
}