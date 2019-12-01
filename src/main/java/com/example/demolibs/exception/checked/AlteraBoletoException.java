package com.example.demolibs.exception.checked;

public class AlteraBoletoException extends Throwable {

    private static final String MESSAGE = "Erro ao executar transação mainframe";

    public AlteraBoletoException() {
        super(MESSAGE);
    }

    public AlteraBoletoException(String message) {
        super(message);
    }

    public AlteraBoletoException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlteraBoletoException(Throwable cause) {
        super(MESSAGE, cause);
    }
    
}
