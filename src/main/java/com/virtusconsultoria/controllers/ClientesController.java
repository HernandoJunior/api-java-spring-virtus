package com.virtusconsultoria.controllers;

import com.virtusconsultoria.model.Clientes;
import com.virtusconsultoria.repository.ClienteRepository;
import com.virtusconsultoria.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    public ClientesService clientesService;

    //ENDPOINT NO CONTROLLER
    @PostMapping("/importar")
    public ResponseEntity<String> importarClientes(@RequestParam("file") MultipartFile file) {
        try {
            List<Clientes> clientes = clientesService.lerPlanilha(file);
            return ResponseEntity.ok("Leitura concluída com sucesso. Total: " + clientes.size());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
