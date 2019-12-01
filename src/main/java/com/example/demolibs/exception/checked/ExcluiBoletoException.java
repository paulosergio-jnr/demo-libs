package com.example.demolibs.exception.checked;

public class ExcluiBoletoException extends Throwable {
    
    private static final String MESSAGE = "Erro ao executar transação mainframe";

    public ExcluiBoletoException() {
        super(MESSAGE);
    }

    public ExcluiBoletoException(String message) {
        super(message);
    }

    public ExcluiBoletoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcluiBoletoException(Throwable cause) {
        super(MESSAGE, cause);
    }
    
}
