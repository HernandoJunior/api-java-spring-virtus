package com.virtusconsultoria.controllers;

import com.virtusconsultoria.config.security.TokenService;
import com.virtusconsultoria.dtos.ColaboradorCreateDto;
import com.virtusconsultoria.dtos.ColaboradorResponseDto;
import com.virtusconsultoria.dtos.LoginRequestDto;
import com.virtusconsultoria.dtos.TokenDto;
import com.virtusconsultoria.model.Colaborador;
import com.virtusconsultoria.service.ColaboradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

    @Autowired
    ColaboradorService colaboradorService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/cadastrarcol")
    @ResponseStatus(HttpStatus.CREATED)
    public ColaboradorResponseDto gravarColaborador(@RequestBody @Valid ColaboradorCreateDto colaboradorCreateDto){
        return colaboradorService.salvarColaborador(colaboradorCreateDto);
    }

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TokenDto> loginColaborador(@RequestBody @Valid LoginRequestDto loginDto) {
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        loginDto.email(),
                        loginDto.senha());

        System.out.println(usernamePassword);

        Authentication auth = authManager.authenticate(usernamePassword);

        String token = tokenService.gerarToken(
                (Colaborador) auth.getPrincipal()
        );

        return ResponseEntity.ok(new TokenDto(token));
    }

    @GetMapping("/listarcol")
    @ResponseStatus(HttpStatus.OK)
    public List<ColaboradorResponseDto> listarColaborador(){
        return colaboradorService.listarColaboradores();
    }


}
