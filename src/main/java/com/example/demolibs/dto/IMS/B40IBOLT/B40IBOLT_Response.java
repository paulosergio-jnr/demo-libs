package com.example.demolibs.dto.IMS.B40IBOLT;

import lombok.Data;

import java.util.List;

@Data
public class B40IBOLT_Response {

    private String codigoRetorno;
    private String mensagemRetorno;

    private long qtdeOcorrencias;

    private List<B40IBOLT_Boleto> listaBoletos;

}
