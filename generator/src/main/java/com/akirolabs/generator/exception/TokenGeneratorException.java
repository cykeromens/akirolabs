package com.akirolabs.generator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TokenGeneratorException extends RuntimeException{

    public TokenGeneratorException(Exception exception) {
        super(exception);
    }
}
