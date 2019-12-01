package com.example.demolibs.business;

import com.example.demolibs.exception.checked.*;
import com.example.demolibs.mapper.BoletoMapper;
import com.example.demolibs.model.Boleto;
import com.example.demolibs.service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.util.Assert.notNull;

@Service
public class BoletoBusiness {

    @Autowired
    BoletoMapper boletoMapper;

    @Autowired
    BoletoService boletoService;

    public List<Boleto> consultaBoletos() throws ConsultaBoletosException {

        return boletoService.findAllBoletos();

    }

    public Boleto consultaBoleto(String idBoleto) throws ConsultaBoletoException, BoletoNaoEncontradoException {

        return boletoService.findBoletoById(idBoleto);

    }

    public Boleto cadastraBoleto(Boleto boleto) throws CadastraBoletoException, ValidacaoBoletoException {

        validaBoletoBasico(boleto);

        return boletoService.insertBoleto(boleto);

    }

    public Boleto alteraBoleto(String idBoleto, Boleto boleto) throws AlteraBoletoException, ValidacaoBoletoException {

        validaBoletoBasico(boleto);

        return boletoService.updateBoleto(idBoleto, boleto);

    }

    public void excluiBoleto(String idBoleto) throws ExcluiBoletoException {

        boletoService.deleteBoleto(idBoleto);

    }


    private void validaBoletoBasico(Boleto boleto) throws ValidacaoBoletoException {

        try {
            notNull(boleto.getDataVencimento(), "Data de vencimento não informada.");
            notNull(boleto.getDataLimiteDesconto(), "Data limite de desconto não informada.");
            notNull(boleto.getDataLimitePagamento(), "Data limite para pagamento não informada.");

            notNull(boleto.getValor(), "Valor do boleto não informado.");
            notNull(boleto.getValorDesconto(), "Valor de desconto boleto não informado.");
            notNull(boleto.getValorJuros(), "Valor de juros boleto não informado.");

            notNull(boleto.getDocumentoBeneficiario(), "Documento do beneficiário não informado.");
            notNull(boleto.getNomePagador(), "Nome do pagador não informado.");

            notNull(boleto.getDocumentoPagador(), "Documento do pagador não informado.");
            notNull(boleto.getNomeBeneficiario(), "Nome do beneficiário não informado.");

            if (boleto.getDataVencimento().isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Data de vencimento não pode ser anterior à data atual.");
            }

            if (!boleto.getDataLimiteDesconto().isBefore(boleto.getDataVencimento())) {
                throw new IllegalArgumentException("Data de desconto deve ser anterior à data de vencimento.");
            }

            if (!boleto.getDataLimitePagamento().isAfter(boleto.getDataVencimento())) {
                throw new IllegalArgumentException("Data limite de pagamento deve ser posterior à data de vencimento.");
            }
        } catch (IllegalArgumentException e) {
            throw new ValidacaoBoletoException(e.getMessage());
        }

    }

}
