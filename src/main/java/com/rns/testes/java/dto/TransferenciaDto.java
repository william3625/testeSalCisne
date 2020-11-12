package com.rns.testes.java.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferenciaDto {
    private Long idFilialOrigem;
    private Long idFilialDestino;
    private Long idProduto;
    private BigDecimal quantidade;
}
