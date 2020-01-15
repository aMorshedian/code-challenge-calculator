package com.code.challenge.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalculatorService {
    private final Logger logger = LoggerFactory.getLogger(SimpleCalculatorService.class);

    public double add(double a, double b) {
        double n = a + b;
        logger.info(a + " + " + b + " = " + n);
        return n;
    }

    public double subtract(double a, double b) {
        double n = a - b;
        logger.info(a + " - " + b + " = " + n);
        return n;

    }

    public double multiple(double a, double b) {
        double n = a * b;
        logger.info(a + " * " + b + " = " + n);
        return n;
    }

    public double divide(double a, double b) {
        if (b == 0f) {
            logger.error("second operator must not be zero");
            throw new IllegalArgumentException("second operand must not be zero");
        }

        double n = a / b;
        logger.info(a + " / " + b + " = " + n);
        return n;
    }
}
