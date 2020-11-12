package com.rns.testes.java.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Table(name = "PRODUTOFILIAL")
@SequenceGenerator(name = "PRODUTOFILIAL_SEQ", sequenceName = "PRODUTO_FILIAL_SEQ", allocationSize = 1)
@Data
public class Estoque extends GenericEntity<Long> {

    @Id
    @GeneratedValue(generator = "PRODUTOFILIAL_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private Long idFilial;

    @Column
    private Long idProduto;

    @Column
    private BigDecimal quantidade;
}
