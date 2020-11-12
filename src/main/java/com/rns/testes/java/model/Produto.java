package com.rns.testes.java.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTO")
@Data
public class Produto extends GenericEntity<Long>{

    @Id
    private Long id;

    @Column
    private String nome;

    @Column
    private String codigo;

}
