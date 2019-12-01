package com.example.demolibs.exception.checked;

public class CadastraBoletoException extends Throwable {

    private static final String MESSAGE = "Erro ao executar transação mainframe";

    public CadastraBoletoException() {
        super(MESSAGE);
    }

    public CadastraBoletoException(String message) {
        super(message);
    }

    public CadastraBoletoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CadastraBoletoException(Throwable cause) {
        super(MESSAGE, cause);
    }

}
