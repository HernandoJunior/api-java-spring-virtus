package com.virtusconsultoria.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_CLIENTES_DADOS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Clientes {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CLIENTES"
    )
    @SequenceGenerator(
           name = "SEQ_CLIENTES",
           sequenceName = "SEQ_CLIENTES",
            initialValue = 1,
            allocationSize = 1
    )
    private Long ID_CLIENTE;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String telefone;

    @Column
    private Double margem;

    @Column
    private String email;

    @Column
    private Integer idade;

    @Column
    private String obito;
}

