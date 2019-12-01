package com.example.demolibs.controller;

import com.example.demolibs.business.BoletoBusiness;
import com.example.demolibs.exception.checked.*;
import com.example.demolibs.mapper.BoletoMapper;
import com.example.demolibs.model.Boleto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class BoletoController {

    @Autowired
    BoletoBusiness boletoBusiness;

    @Autowired
    BoletoMapper boletoMapper;


    @GetMapping("/boleto")
    public ResponseEntity<?> consultaBoletos(){

        try {

            List<Boleto> boletos = boletoBusiness.consultaBoletos();
            return ResponseEntity.ok(boletoMapper.toConsultaBoletosResponse(boletos));

        } catch (ConsultaBoletosException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/boleto/{id_boleto}")
    public ResponseEntity<?> consultaBoleto(@PathVariable("id_boleto") String idBoleto) {

        try {

            Boleto boleto = boletoBusiness.consultaBoleto(idBoleto);
            return ResponseEntity.ok(boletoMapper.toConsultaBoletoResponse(boleto));

        } catch (ConsultaBoletoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (BoletoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }

    }


    @PostMapping("/boleto")
    public ResponseEntity<?> cadastroBoleto(@RequestBody Boleto boleto) throws URISyntaxException {

        try {

            Boleto boletoCadastrado = boletoBusiness.cadastraBoleto(boleto);
            return ResponseEntity.created(new URI("")).body(boletoCadastrado);

        } catch (CadastraBoletoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ValidacaoBoletoException e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

    }

    @PutMapping("/boleto/{id_boleto}")
    public ResponseEntity<?> alteraBoleto(@PathVariable("id_boleto") String idBoleto, @RequestBody Boleto boleto) {

        try {

            Boleto boletoAlterado = boletoBusiness.alteraBoleto(idBoleto, boleto);
            return ResponseEntity.ok(boletoAlterado);

        } catch (AlteraBoletoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ValidacaoBoletoException e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

    }

    @DeleteMapping("/boleto/{id_boleto}")
    public ResponseEntity<?> excluiBoleto(@PathVariable("id_boleto") String idBoleto) {

        try {

            boletoBusiness.excluiBoleto(idBoleto);
            return ResponseEntity.noContent().build();

        } catch (ExcluiBoletoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
