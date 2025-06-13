package com.virtusconsultoria.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;

import java.util.List;

@Entity
@Table(name = "TBL_VENDA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Venda {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_VENDA"
    )
    @SequenceGenerator(
            name = "SEQ_VENDA",
            sequenceName = "SEQ_VENDA",
            initialValue = 1,
            allocationSize = 1
    )
    private Long ID_VENDA;

    @ManyToOne
    @JoinColumn(name = "ID_COLABORADOR", nullable = false)
    private Colaborador colaborador;

    @Column
    private Double valor_venda;

    @Column
    private Double comissao;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Clientes clientes;
}
