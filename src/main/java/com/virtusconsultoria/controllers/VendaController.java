package com.virtusconsultoria.controllers;

import com.virtusconsultoria.model.Venda;
import com.virtusconsultoria.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    VendaService vendaService;

    @PostMapping("/cadastrarven")
    @ResponseStatus(HttpStatus.CREATED)
    public Venda cadastrarVenda(Venda venda){
        return vendaService.registrarVenda(venda);
    }

    @GetMapping("/listarven")
    public List<Venda> listarVendas(Venda venda){
        return vendaService.exibirVendas(venda);
    }
}
