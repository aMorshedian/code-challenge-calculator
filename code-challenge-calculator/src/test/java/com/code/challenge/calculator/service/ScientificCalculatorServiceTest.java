package com.code.challenge.calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ScientificCalculatorServiceTest {

    ScientificCalculatorService service = new ScientificCalculatorService();

    @Test
    public void factorialTest() {
        assertEquals(6, service.factorial(3d));
        assertEquals(24, service.factorial(4d));
        assertEquals(120, service.factorial(5d));
    }

    @Test
    public void factorialInvalidInputTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> service.factorial(120));
        assertEquals("the value must be int or long and between 1 and 59", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> service.factorial(5.5));
        assertEquals("the value must be int or long and between 1 and 59", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> service.factorial(-10));
        assertEquals("the value must be int or long and between 1 and 59", exception.getMessage());
    }

    @Test
    public void squareTest() {
        assertEquals(6, service.square(36d));
        assertEquals(4, service.square(16d));
        assertEquals(5, service.square(25d));
    }

    @Test
    public void squareInvalidInputTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> service.square(-120));
        assertEquals("the value must be greater than 0", exception.getMessage());
    }

    @Test
    public void isPrimeTest() {
        assertTrue(service.isPrime(7d));
        assertTrue(service.isPrime(17d));
        assertFalse(service.isPrime(21d));
        assertFalse(service.isPrime(9d));
    }

    @Test
    public void isPrimeInvalidInputTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> service.isPrime(-120));
        assertEquals("the value must be int or long and greater than 0", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> service.isPrime(11.25));
        assertEquals("the value must be int or long and greater than 0", exception.getMessage());
    }
}