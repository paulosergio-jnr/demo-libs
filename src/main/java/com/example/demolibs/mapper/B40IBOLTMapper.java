package com.example.demolibs.mapper;

import com.example.demolibs.dto.IMS.B40IBOLT.B40IBOLT_Boleto;
import com.example.demolibs.dto.IMS.B40IBOLT.B40IBOLT_Request;
import com.example.demolibs.model.Boleto;
import org.springframework.stereotype.Service;

@Service
public class B40IBOLTMapper {

    public B40IBOLT_Request map(Boleto boleto) {
        return new B40IBOLT_Request();
    }

    public Boleto toBoleto(B40IBOLT_Boleto request) {
        return new Boleto();
    }

}
