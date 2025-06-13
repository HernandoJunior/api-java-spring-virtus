package com.virtusconsultoria.service;

import com.virtusconsultoria.model.Venda;
import com.virtusconsultoria.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    public VendaRepository vendaRepository;

    public Venda registrarVenda(Venda venda){
        return vendaRepository.save(venda);
    }

    public List<Venda> exibirVendas(Venda venda){
        return vendaRepository.findAll();
    }
}
