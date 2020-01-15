package com.code.challenge.calculator.dto.request;

import java.io.Serializable;

public class ScientificOperationCommandDTO implements Serializable {

    private Double operator;
    private ScientificOperation operation;

    public ScientificOperationCommandDTO() {
    }

    public Double getOperator() {
        return operator;
    }

    public void setOperator(Double operator) {
        this.operator = operator;
    }

    public ScientificOperation getOperation() {
        return operation;
    }

    public void setOperation(ScientificOperation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "{" +
                "operator=" + operator +
                ", operation=" + operation +
                '}';
    }
}
