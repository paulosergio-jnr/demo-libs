package com.example.demolibs.mapper;

import com.example.demolibs.dto.IMS.B40IBOLT.B40IBOLT_Boleto;
import com.example.demolibs.dto.IMS.B40IBOLT.B40IBOLT_Request;
import com.example.demolibs.model.Boleto;
import org.springframework.stereotype.Service;

import java.time.ZoneId;

@Service
public class B40IBOLTMapper {

    public B40IBOLT_Request map(Boleto boleto) {
        return new B40IBOLT_Request();
    }

    public Boleto toBoleto(B40IBOLT_Boleto model) {

        Boleto boleto = new Boleto();

        boleto.setId(model.getIdBoleto());
        boleto.setNossoNumero(model.getNossoNumero());
        boleto.setIdentificadorBarra(model.getBarra());
        boleto.setDescritivo(model.getDescritivo());
        boleto.setDataVencimento(model.getDataVencimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        boleto.setDataLimiteDesconto(model.getDataLimiteDesconto().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        boleto.setDataLimitePagamento(model.getDataLimitePagamento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        boleto.setValor(model.getValor());
        boleto.setValorDesconto(model.getValorDesconto());
        boleto.setValorJuros(model.getValorJuros());
        boleto.setDocumentoBeneficiario(model.getDocumentoBeneficiario());
        boleto.setNomeBeneficiario(model.getNomeBeneficiario());
        boleto.setDocumentoPagador(model.getDocumentoPagador());
        boleto.setNomePagador(model.getNomePagador());

        return boleto;
    }

}
