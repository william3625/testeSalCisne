package com.rns.testes.java.seeder;

import com.rns.testes.java.model.Produto;
import com.rns.testes.java.service.IProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProdutoSeeder {

    @Autowired
    IProdutoService service;

    @EventListener
    public void seedFilial(ContextRefreshedEvent event) {
        try {
            log.info("Criando produtos....");
            criandoFiliais();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private void criandoFiliais() {
        for (Long i = 1L; i < 25L; i++) {
            Produto produto = new Produto();
            produto.setId(i);
            produto.setCodigo("Cod-Produto-"+i);
            produto.setNome("Sal produto " + i);
            service.save(produto);
        }
    }
}