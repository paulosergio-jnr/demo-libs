package com.example.demolibs.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Boleto {

    private String id;
    private String nossoNumero;
    private String identificadorBarra;
    private String descritivo;

    private LocalDate dataVencimento;
    private LocalDate dataLimiteDesconto;
    private LocalDate dataLimitePagamento;

    private BigDecimal valor;
    private BigDecimal valorDesconto;
    private BigDecimal valorJuros;

    private String documentoBeneficiario;
    private String nomeBeneficiario;

    private String documentoPagador;
    private String nomePagador;

}
