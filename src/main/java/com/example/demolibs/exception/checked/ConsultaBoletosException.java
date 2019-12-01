package com.example.demolibs.exception.checked;

public class ConsultaBoletosException extends Throwable {

    private static final String MESSAGE = "Erro ao executar transação mainframe";

    public ConsultaBoletosException() {
        super(MESSAGE);
    }

    public ConsultaBoletosException(String message) {
        super(message);
    }

    public ConsultaBoletosException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsultaBoletosException(Throwable cause) {
        super(MESSAGE, cause);
    }

}
