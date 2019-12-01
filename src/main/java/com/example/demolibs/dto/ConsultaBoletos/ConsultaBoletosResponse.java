package com.example.demolibs.dto.ConsultaBoletos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ConsultaBoletosResponse {

    @JsonProperty("lista_boletos")
    public List<ConsultaBoletosDetalheResponse> boletos;

}
