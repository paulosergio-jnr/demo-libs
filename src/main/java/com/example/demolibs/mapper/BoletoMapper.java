package com.example.demolibs.mapper;

import com.example.demolibs.dto.AlteraBoleto.AlteraBoletoRequest;
import com.example.demolibs.dto.AlteraBoleto.AlteraBoletoResponse;
import com.example.demolibs.dto.CadastroBoleto.CadastroBoletoRequest;
import com.example.demolibs.dto.CadastroBoleto.CadastroBoletoResponse;
import com.example.demolibs.dto.ConsultaBoleto.ConsultaBoletoResponse;
import com.example.demolibs.dto.ConsultaBoletos.ConsultaBoletosResponse;
import com.example.demolibs.dto.ExcluiBoleto.ExcluiBoletoResponse;
import com.example.demolibs.model.Boleto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletoMapper {

    public Boleto map(CadastroBoletoRequest request) {
        return new Boleto();
    }

    public Boleto map(AlteraBoletoRequest request) {
        return new Boleto();
    }

    public CadastroBoletoResponse toCadastroBoletoResponse(Boleto boleto) {
        return new CadastroBoletoResponse();
    }

    public AlteraBoletoResponse toAlteraBoletoRequest(Boleto boleto) {
        return new AlteraBoletoResponse();
    }

    public ExcluiBoletoResponse toExcluiBoletoResponse(Boleto boleto) {
        return new ExcluiBoletoResponse();
    }

    public ConsultaBoletoResponse toConsultaBoletoResponse(Boleto boleto) {

        ConsultaBoletoResponse response = new ConsultaBoletoResponse();


        return response;
    }

    public ConsultaBoletosResponse toConsultaBoletosResponse(List<Boleto> boleto) {
        return new ConsultaBoletosResponse();
    }


}
