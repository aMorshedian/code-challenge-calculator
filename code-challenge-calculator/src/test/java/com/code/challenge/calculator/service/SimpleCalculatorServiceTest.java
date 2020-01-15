package com.code.challenge.calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleCalculatorServiceTest {

    SimpleCalculatorService service = new SimpleCalculatorService();

    @Test
    public void addTest() {
        assertEquals(25.5, service.add(5.5d, 20d));
        assertEquals(3, service.add(-1d, 4d));
        assertEquals(30, service.add(15.5d, 14.5d));
    }


    @Test
    public void subtractTest() {
        assertEquals(-20.5, service.subtract(5.5d, 26d));
        assertEquals(-5, service.subtract(-1d, 4d));
        assertEquals(1, service.subtract(15.5d, 14.5d));
    }


    @Test
    public void multipleTest() {
        assertEquals(25, service.multiple(5d, 5d));
        assertEquals(3, service.multiple(-1d, -3d));
        assertEquals(30, service.multiple(15d, 2d));
    }


    @Test
    public void divideTest() {
        assertEquals(2.5, service.divide(5.0d, 2d));
        assertEquals(-2, service.divide(-10d, 5d));
        assertEquals(30, service.divide(90d, 3d));
    }


    @Test
    public void divideByZeroTest() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> service.divide(12d, 0d));
        assertEquals("second operand must not be zero", exception.getMessage());
    }
}
