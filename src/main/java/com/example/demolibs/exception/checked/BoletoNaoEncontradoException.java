package com.example.demolibs.exception.checked;

public class BoletoNaoEncontradoException extends Throwable {

    private static final String MESSAGE = "Boleto não encontrado na base.";

    public BoletoNaoEncontradoException() {
        super(MESSAGE);
    }

    public BoletoNaoEncontradoException(String message) {
        super(message);
    }

    public BoletoNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoletoNaoEncontradoException(Throwable cause) {
        super(MESSAGE, cause);
    }

}
