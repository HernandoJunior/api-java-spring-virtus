package com.virtusconsultoria.service;

import com.virtusconsultoria.model.PropostaVenda;
import com.virtusconsultoria.repository.PropostaVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaVendaService {

    @Autowired
    public PropostaVendaRepository propostaVendaRepository;

    public PropostaVenda registrarProposta(PropostaVenda propostaVenda){
        return propostaVendaRepository.save(propostaVenda);
    }

    public List<PropostaVenda> listarPropostas(){
        return propostaVendaRepository.findAll();
    }
}
