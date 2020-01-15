package com.code.challenge.calculator.controller.v1;

import com.code.challenge.calculator.dto.request.SimpleOperationCommandDTO;
import com.code.challenge.calculator.service.SimpleCalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/simpleCalculator")
public class SimpleCalculatorController {
    private static Logger logger = LoggerFactory.getLogger(SimpleCalculatorController.class);
    private final SimpleCalculatorService service;

    public SimpleCalculatorController(SimpleCalculatorService service) {
        this.service = service;
    }

    @PutMapping("/generic")
    public Double simpleCalculate(@RequestBody SimpleOperationCommandDTO commandData) {
        logger.debug("the input data is " + commandData.toString());
        switch (commandData.getOperation()) {
            case ADD:
                return service.add(commandData.getFirstOperator(), commandData.getSecondOperator());
            case SUB:
                return service.subtract(commandData.getFirstOperator(), commandData.getSecondOperator());
            case MUL:
                return service.multiple(commandData.getFirstOperator(), commandData.getSecondOperator());
            case DIV:
                return service.divide(commandData.getFirstOperator(), commandData.getSecondOperator());

        }
        logger.error("invalid action " + commandData.toString());
        throw new IllegalArgumentException("invalid action");
    }

    @GetMapping("/{firstOperator}/add/{secondOperator}")
    public double add(@PathVariable double firstOperator, @PathVariable double secondOperator) {
        logger.info("add operation is called for " + firstOperator + " and " + secondOperator);
        return service.add(firstOperator, secondOperator);
    }

    @GetMapping("/{firstOperator}/sub/{secondOperator}")
    public double subtract(@PathVariable double firstOperator, @PathVariable double secondOperator) {
        logger.info("subtract operation is called for " + firstOperator + " and " + secondOperator);
        return service.subtract(firstOperator, secondOperator);
    }

    @GetMapping("/{firstOperator}/mul/{secondOperator}")
    public double multiply(@PathVariable double firstOperator, @PathVariable double secondOperator) {
        logger.info("multiply operation is called for " + firstOperator + " and " + secondOperator);
        return service.multiple(firstOperator, secondOperator);
    }

    @GetMapping("/{firstOperator}/div/{secondOperator}")
    public double divide(@PathVariable double firstOperator, @PathVariable double secondOperator) {
        logger.info("divide operation is called for " + firstOperator + " and " + secondOperator);
        return service.divide(firstOperator, secondOperator);
    }
}
