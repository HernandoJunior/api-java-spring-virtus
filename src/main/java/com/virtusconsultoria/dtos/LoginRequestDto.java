package com.virtusconsultoria.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequestDto(
        @NotBlank(message = "Email obrigatório")
        @Email(message = "Campo email é obritagorio")
        String email,

        @NotBlank(message = "Senha obrigatória")
        @Size(min = 6, max = 20, message = "Campo senha obrigatório e deve conter 6 a 20 caracteres")
        String senha
) {
}
