package com.virtusconsultoria.controllers;

import com.virtusconsultoria.model.PropostaVenda;
import com.virtusconsultoria.service.PropostaVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proposta")
public class PropostaVendaController {

    @Autowired
    public PropostaVendaService propostaVendaService;

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public PropostaVenda criarVenda(@RequestBody PropostaVenda propostaVenda){
        return propostaVendaService.registrarProposta(propostaVenda);
    }

}
