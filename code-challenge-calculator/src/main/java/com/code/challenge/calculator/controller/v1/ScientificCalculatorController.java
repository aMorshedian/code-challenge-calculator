package com.code.challenge.calculator.controller.v1;

import com.code.challenge.calculator.dto.request.ScientificOperationCommandDTO;
import com.code.challenge.calculator.dto.response.ScientificOutputDTO;
import com.code.challenge.calculator.service.ScientificCalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/scientificCalculator")
public class ScientificCalculatorController {
    private final ScientificCalculatorService service;
    private final Logger logger = LoggerFactory.getLogger(ScientificCalculatorController.class);

    public ScientificCalculatorController(ScientificCalculatorService service) {
        this.service = service;
    }

    @PutMapping("/generic")
    public ScientificOutputDTO<?> scientificCalculator(@RequestBody ScientificOperationCommandDTO commandData) {
        logger.info("input data is " + commandData.toString());
        switch (commandData.getOperation()) {
            case FAC:
                return new ScientificOutputDTO<Long>(service.factorial(commandData.getOperator()));
            case SQR:
                return new ScientificOutputDTO<Double>(service.square(commandData.getOperator()));
            case PRM:
                return new ScientificOutputDTO<Boolean>(service.isPrime(commandData.getOperator()));
        }
        logger.error("invalid action " + commandData.toString());
        throw new IllegalArgumentException("invalid action");

    }

    @GetMapping("/factorial/{number}")
    public long factorial(@PathVariable("number") int number) {
        logger.info("factorial is called for " + number);
        return service.factorial(new Double(number));
    }

    @GetMapping("/is-prime/{number}")
    public boolean isPrime(@PathVariable("number") long number) {
        logger.info("is-prime operation is called for " + number);
        return service.isPrime(new Double(number));
    }

    @GetMapping("/square/{number}")
    public Double square(@PathVariable("number") double number) {
        logger.info("square is called for " + number);
        return service.square(number);
    }
}
