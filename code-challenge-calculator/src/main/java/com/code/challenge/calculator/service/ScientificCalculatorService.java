package com.code.challenge.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ScientificCalculatorService {

    private final Logger logger = LoggerFactory.getLogger(ScientificCalculatorService.class);

    @Cacheable("factorial")
    public long factorial(double a) {
        if (a % 1 != 0 || a < 1 || a > 59) {
            logger.error("the value must be int or long and between 1 and 59 " + a);
            throw new IllegalArgumentException("the value must be int or long and between 1 and 59");
        }
        long factorial = 1l;
        for (long i = 2L; i <= a; i++)
            factorial *= i;
        logger.info(a + " factorial is equal to " + factorial);
        return factorial;

    }

    public Double square(double a) {
        if (a < 0) {
            logger.error("the value must be greater than 0 " + a);
            throw new IllegalArgumentException("the value must be greater than 0");
        }
        return Math.sqrt(a);
    }

    @Cacheable("isPrime")
    public boolean isPrime(double a) {
        if (a % 1 != 0 || a < 0) {
            logger.error("the value must be int or long and greater than 0" + a);
            throw new IllegalArgumentException("the value must be int or long and greater than 0");
        }

        for (long l = 2; l <= a / 2; l++) {
            if (a % l == 0) {
                logger.info(a + " is not a prime number");
                return false;
            }

        }
        logger.info(a + " is not a number");
        return true;
    }
}
