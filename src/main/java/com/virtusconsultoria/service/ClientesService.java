package com.virtusconsultoria.service;

import com.virtusconsultoria.model.Clientes;
import com.virtusconsultoria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientesService {

    @Autowired
    public ClienteRepository clienteRepository;


    public List<Clientes> lerPlanilha(MultipartFile file) throws IOException {
        List<Clientes> clientesList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8)
        );

        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] partes = linha.split(";");

            String cpf = partes.length > 0 ? partes[0].replaceAll("\\D", "") : "";
            String nome = partes.length > 1 ? partes[1] : "";
            String telefone1 = partes.length > 2 ? partes[2] : "";
            String telefone2 = partes.length > 3 ? partes[3] : "";
            String telefone3 = partes.length > 4 ? partes[4] : "";

            System.out.println("CPF : " + cpf);
            System.out.println("Nome : " + nome);
            System.out.println("Telefone 1 : " + telefone1);
            System.out.println("Telefone 2 : " + telefone2);
            System.out.println("Telefone 3 : " + telefone3);

//            if (!cpf.isEmpty()) {
//                Clientes cliente = new Clientes();
//                cliente.setCpf(cpf);
//                cliente.setNome(nome);
//                cliente.setTelefone(telefone1); // ou concatene todos
//                cliente.setObito("N");
//                cliente.setMargem(0.0);
//                cliente.setEmail("");
//                cliente.setIdade(null);
//                clientesList.add(cliente);
            }

        return clientesList;
    }
}

