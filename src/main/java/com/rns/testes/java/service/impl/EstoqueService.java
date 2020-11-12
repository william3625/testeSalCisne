package com.rns.testes.java.service.impl;

import com.rns.testes.java.dao.IEstoqueDao;
import com.rns.testes.java.dto.TransferenciaDto;
import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.service.AbstractGenericServicePersistence;
import com.rns.testes.java.service.IEstoqueService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;


@Service
public class EstoqueService extends AbstractGenericServicePersistence<IEstoqueDao, Estoque, Long> implements IEstoqueService {

    @Override
    public Estoque save(Estoque estoque) {
        BigDecimal quantidade = estoque.getQuantidade();
        estoque = dao.findByIdFilialAndIdProduto(estoque.getIdFilial(), estoque.getIdProduto()).orElse(estoque);
        if(estoque.getId() != null){
            estoque.setQuantidade(estoque.getQuantidade().add(quantidade));
        }
        return super.save(estoque);
    }

    public Estoque transfer(TransferenciaDto transferencia){
        Optional<Estoque> optional = dao.findByIdFilialAndIdProduto(transferencia.getIdFilialOrigem(), transferencia.getIdFilialDestino());
        if (!optional.isPresent())
            throw new UnsupportedOperationException("Estoque não encontrado");

        Estoque estoque = optional.get();
        if (estoque.getQuantidade().compareTo(transferencia.getQuantidade()) == -1)
            throw new UnsupportedOperationException("Saldo insuficiente");

        estoque.setQuantidade(estoque.getQuantidade().subtract(transferencia.getQuantidade()));
        dao.save(estoque);

        Estoque estoqueDestino = new Estoque();
        estoqueDestino.setIdFilial(transferencia.getIdFilialDestino());
        estoqueDestino.setIdProduto(transferencia.getIdProduto());
        estoqueDestino.setQuantidade(transferencia.getQuantidade());
        dao.save(estoqueDestino);

        return estoqueDestino;
    }
}
