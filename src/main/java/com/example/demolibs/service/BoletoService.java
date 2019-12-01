package com.example.demolibs.service;

import com.example.demolibs.dto.IMS.B40IBOLT.B40IBOLT_Request;
import com.example.demolibs.dto.IMS.B40IBOLT.B40IBOLT_Response;
import com.example.demolibs.exception.checked.*;
import com.example.demolibs.mapper.B40IBOLTMapper;
import com.example.demolibs.model.Boleto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoletoService {

    @Autowired
    B40IBOLTMapper b4Mapper;

    public List<Boleto> findAllBoletos() throws ConsultaBoletosException {

        B40IBOLT_Request request = new B40IBOLT_Request();

        request.setPasso("1");

        // TODO Chamada Mainframe
        B40IBOLT_Response response = new B40IBOLT_Response();

        if (!response.getCodigoRetorno().equals("00")) {
            throw new ConsultaBoletosException(response.getMensagemRetorno());
        }

        List<Boleto> listaBoletos = new ArrayList<>();

        response.getListaBoletos().forEach(item -> {
            Boleto boleto = b4Mapper.toBoleto(item);
            listaBoletos.add(boleto);
        });

        return listaBoletos;

    }

    public Boleto findBoletoById(String idBoleto) throws ConsultaBoletoException, BoletoNaoEncontradoException {

        B40IBOLT_Request request = new B40IBOLT_Request();

        request.setPasso("2");
        request.setIdBoleto(idBoleto);

        // TODO Chamada Mainframe
        B40IBOLT_Response response = new B40IBOLT_Response();

        if (!response.getCodigoRetorno().equals("00")) {
            if (response.getCodigoRetorno().equals("01")) {
                throw new BoletoNaoEncontradoException();
            } else {
                throw new ConsultaBoletoException(response.getMensagemRetorno());
            }
        }

        Boleto boleto = b4Mapper.toBoleto(response.getListaBoletos().get(0));

        return boleto;

    }

    public Boleto insertBoleto(Boleto boleto) throws CadastraBoletoException {

        B40IBOLT_Request request = b4Mapper.map(boleto);

        request.setPasso("3");

        // TODO Chamada Mainframe
        B40IBOLT_Response response = new B40IBOLT_Response();

        if (!response.getCodigoRetorno().equals("00")) {
            throw new CadastraBoletoException(response.getMensagemRetorno());
        }

        return b4Mapper.toBoleto(response.getListaBoletos().get(0));

    }

    public Boleto updateBoleto(String idBoleto, Boleto boleto) throws AlteraBoletoException {

        B40IBOLT_Request request = b4Mapper.map(boleto);

        request.setPasso("4");
        request.setIdBoleto(idBoleto);

        // TODO Chamada Mainframe
        B40IBOLT_Response response = new B40IBOLT_Response();

        if (!response.getCodigoRetorno().equals("00")) {
            throw new AlteraBoletoException(response.getMensagemRetorno());
        }

        return b4Mapper.toBoleto(response.getListaBoletos().get(0));

    }

    public void deleteBoleto(String idBoleto) throws ExcluiBoletoException {

        B40IBOLT_Request request = new B40IBOLT_Request();

        request.setPasso("5");
        request.setIdBoleto(idBoleto);

        // TODO Chamada Mainframe
        B40IBOLT_Response response = new B40IBOLT_Response();

        if (!response.getCodigoRetorno().equals("00")) {
            throw new ExcluiBoletoException(response.getMensagemRetorno());
        }

    }

}
