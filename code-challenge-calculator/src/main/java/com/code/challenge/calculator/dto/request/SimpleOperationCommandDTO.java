package com.code.challenge.calculator.dto.request;

import java.io.Serializable;

public class SimpleOperationCommandDTO implements Serializable {

    private Double firstOperator;
    private Double secondOperator;
    private SimpleOperation operation;

    public SimpleOperationCommandDTO() {
    }

    public Double getFirstOperator() {
        return firstOperator;
    }

    public void setFirstOperator(Double firstOperator) {
        this.firstOperator = firstOperator;
    }

    public Double getSecondOperator() {
        return secondOperator;
    }

    public void setSecondOperator(Double secondOperator) {
        this.secondOperator = secondOperator;
    }

    public SimpleOperation getOperation() {
        return operation;
    }

    public void setOperation(SimpleOperation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "{" +
                "firstOperator=" + firstOperator +
                ", secondOperator=" + secondOperator +
                ", operation=" + operation +
                '}';
    }
}
