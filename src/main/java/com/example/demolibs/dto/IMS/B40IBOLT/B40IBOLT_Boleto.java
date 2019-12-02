package com.example.demolibs.dto.IMS.B40IBOLT;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class B40IBOLT_Boleto {

    private String idBoleto;

    private String nossoNumero;

    private String barra;

    private String descritivo;


    private Date dataVencimento;

    private Date dataLimiteDesconto;

    private Date dataLimitePagamento;


    private BigDecimal valor;

    private BigDecimal valorDesconto;

    private BigDecimal valorJuros;


    private String documentoBeneficiario;

    private String nomeBeneficiario;


    private String documentoPagador;

    private String nomePagador;

}
