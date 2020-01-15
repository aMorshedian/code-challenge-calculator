package com.code.challenge.calculator.exception;

import com.code.challenge.calculator.dto.response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value
            = {RuntimeException.class, IllegalStateException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO badRequest(Exception ex) {
        return new ErrorResponseDTO(400, ex.getMessage());
    }


}
