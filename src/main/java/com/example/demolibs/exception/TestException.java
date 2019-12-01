package com.example.demolibs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TestException extends RuntimeException {

    private static final String MESSAGE = "Algum erro foi encontrado.";

    public TestException() {
        super(MESSAGE);
    }

    public TestException(String message) {
        super(message);
    }

    public TestException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
