package com.rns.testes.java.dao;


import com.rns.testes.java.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IEstoqueDao extends JpaRepository<Estoque, Long> {

    Optional<Estoque> findByIdFilialAndIdProduto(@Param("idFilial") Long idFilial, @Param("idProduto") Long idProduto);

}
