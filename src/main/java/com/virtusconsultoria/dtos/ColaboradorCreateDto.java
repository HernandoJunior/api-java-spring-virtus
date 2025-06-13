package com.virtusconsultoria.dtos;

//import com.virtusconsultoria.model.ColaboradorRole;
import com.virtusconsultoria.model.ColaboradorRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ColaboradorCreateDto(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "Email obrigatório")
        @Email(message = "Email não é valido")
        String email,

        @NotBlank(message = "Senha obrigatória")
        @Size(min = 6, max = 10, message = "A senha deve conter entre 6 e 10 caracteres")
        String senha,

        @NotBlank(message = "Campo CPF obrigatório")
        @Size (min = 10, max = 11, message = "Campo CPF são 11 digitos")
        String cpf,

        @NotNull(message = "Nivel de usuário obrigatório (Admin / User)")
        ColaboradorRole role

) { }
