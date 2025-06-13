package com.virtusconsultoria.service;

import com.virtusconsultoria.dtos.ColaboradorCreateDto;
import com.virtusconsultoria.dtos.ColaboradorResponseDto;
import com.virtusconsultoria.model.Clientes;
import com.virtusconsultoria.model.Colaborador;
import com.virtusconsultoria.repository.ColaboradorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    public ColaboradorRepository colaboradorRepository;

    public ColaboradorResponseDto salvarColaborador(ColaboradorCreateDto colaboradorDto){
        String senhaCriptografada = new BCryptPasswordEncoder().encode(colaboradorDto.senha());

        if (colaboradorRepository.existsByEmail(colaboradorDto.email())){
             throw new RuntimeException("Email já existente!");
        }

        Colaborador colaborador = new Colaborador();
        BeanUtils.copyProperties(colaboradorDto, colaborador);
        colaborador.setSenha(senhaCriptografada);

        Colaborador colaboradorSalvo = colaboradorRepository.save(colaborador);

        return new ColaboradorResponseDto(colaboradorSalvo);
    }

    public List<ColaboradorResponseDto> listarColaboradores(){
        return colaboradorRepository.findAll()
                .stream()
                .map(ColaboradorResponseDto::new)
                .toList();
    }


}
