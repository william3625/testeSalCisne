package com.rns.testes.java.dto;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class EstoqueDto {
    private Long id;
    private Long idFilial;
    private Long idProduto;
    private BigDecimal quantidade;
}
