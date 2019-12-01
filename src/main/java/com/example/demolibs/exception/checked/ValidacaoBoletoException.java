package com.example.demolibs.exception.checked;

public class ValidacaoBoletoException extends Throwable {
   
    private static final String MESSAGE = "Erro ao executar transação mainframe";

    public ValidacaoBoletoException() {
        super(MESSAGE);
    }

    public ValidacaoBoletoException(String message) {
        super(message);
    }

    public ValidacaoBoletoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidacaoBoletoException(Throwable cause) {
        super(MESSAGE, cause);
    }
    
}
