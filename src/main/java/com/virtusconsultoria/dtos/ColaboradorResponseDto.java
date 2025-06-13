package com.virtusconsultoria.dtos;

import com.virtusconsultoria.model.Colaborador;
import com.virtusconsultoria.model.ColaboradorRole;
//import com.virtusconsultoria.model.ColaboradorRole;

public record ColaboradorResponseDto(
    Long ID_COLABORADOR,
    String nome,
    String cpf,
    String email,
    ColaboradorRole role
) {
    public ColaboradorResponseDto(Colaborador colaborador){
        this(
                colaborador.getID_COLABORADOR(),
                colaborador.getNome(),
                colaborador.getCpf(),
                colaborador.getEmail(),
                colaborador.getRole()
        );
    }
}
