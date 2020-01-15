package com.code.challenge.calculator.dto.response;

public class ScientificOutputDTO<T> {

    private T data;

    public ScientificOutputDTO(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
