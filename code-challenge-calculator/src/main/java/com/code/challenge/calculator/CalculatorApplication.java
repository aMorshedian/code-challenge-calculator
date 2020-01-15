package com.code.challenge.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CalculatorApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
        LOGGER.info("System has been started");
    }

}
