package com.example.demolibs.dto.CadastroBoleto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CadastroBoletoRequest {

    @JsonProperty("descritivo_boleto")
    private String descritivo;


    @JsonProperty("data_vencimento")
    @JsonFormat(pattern = "dd/MM/uuuu")
    private LocalDate dataVencimento;

    @JsonProperty("data_limite_desconto")
    @JsonFormat(pattern = "dd/MM/uuuu")
    private LocalDate dataLimiteDesconto;

    @JsonProperty("data_limite_pagamento")
    @JsonFormat(pattern = "dd/MM/uuuu")
    private LocalDate dataLimitePagamento;


    @JsonProperty("valor_documento")
    private BigDecimal valor;

    @JsonProperty("valor_desconto")
    private BigDecimal valorDesconto;

    @JsonProperty("valor_juros")
    private BigDecimal valorJuros;


    @JsonProperty("documento_beneficiario")
    private String documentoBeneficiario;

    @JsonProperty("nome_beneficiario")
    private String nomeBeneficiario;

    @JsonProperty("documento_pagador")
    private String documentoPagador;

    @JsonProperty("nome_pagador")
    private String nomePagador;

}
