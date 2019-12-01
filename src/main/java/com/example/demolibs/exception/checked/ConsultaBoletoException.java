package com.example.demolibs.exception.checked;

public class ConsultaBoletoException extends Throwable {

    private static final String MESSAGE = "Erro ao executar transação mainframe";

    public ConsultaBoletoException() {
        super(MESSAGE);
    }

    public ConsultaBoletoException(String message) {
        super(message);
    }

    public ConsultaBoletoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsultaBoletoException(Throwable cause) {
        super(MESSAGE, cause);
    }

}
