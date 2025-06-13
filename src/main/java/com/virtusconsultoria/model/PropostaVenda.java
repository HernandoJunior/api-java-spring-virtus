package com.virtusconsultoria.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_PROPOSTA_VENDA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PropostaVenda {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_PROP_VENDA"
    )
    @SequenceGenerator(
            name = "SEQ_PROP_VENDA",
            sequenceName = "SEQ_PROP_VENDA",
            initialValue = 1,
            allocationSize = 1
    )
    private Long ID_PROPOSTA;

    @ManyToOne
    @JoinColumn(name = "ID_COLABORADOR", nullable = false)
    private Colaborador colaborador;

    @Column
    private String banco;

    @Column
    private Double parcela_utilizada;

    @Column
    private int prazo;

    @Column
    private double valor_liberado;

    @Column
    private double valor_limite;

}
