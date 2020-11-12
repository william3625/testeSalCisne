package com.rns.testes.java.seeder;

import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.service.IEstoqueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class EstoqueSeeder {

    @Autowired
    IEstoqueService service;

    @EventListener
    public void seedFilial(ContextRefreshedEvent event) {
        try {
            log.info("Criando produtos/filiais....");
            criandoFiliais();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    private void criandoFiliais() {
        Estoque estoque = new Estoque();
        estoque.setIdFilial((long) 1);
        estoque.setIdProduto((long) 1);
        estoque.setQuantidade(new BigDecimal(1000));
        service.save(estoque);

        Estoque estoque1 = new Estoque();
        estoque1.setIdFilial((long) 1);
        estoque1.setIdProduto((long) 2);
        estoque1.setQuantidade(new BigDecimal(2000));
        service.save(estoque1);
    }
}
