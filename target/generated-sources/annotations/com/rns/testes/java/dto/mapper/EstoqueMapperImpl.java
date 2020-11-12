package com.rns.testes.java.dto.mapper;

import com.rns.testes.java.dto.EstoqueDto;
import com.rns.testes.java.model.Estoque;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-11T23:05:52-0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
public class EstoqueMapperImpl implements EstoqueMapper {

    @Override
    public EstoqueDto entityToDto(Estoque entity) {
        if ( entity == null ) {
            return null;
        }

        EstoqueDto estoqueDto = new EstoqueDto();

        estoqueDto.setId( entity.getId() );
        estoqueDto.setIdFilial( entity.getIdFilial() );
        estoqueDto.setIdProduto( entity.getIdProduto() );
        estoqueDto.setQuantidade( entity.getQuantidade() );

        return estoqueDto;
    }

    @Override
    public Estoque dtoToEntity(EstoqueDto dto) {
        if ( dto == null ) {
            return null;
        }

        Estoque estoque = new Estoque();

        estoque.setId( dto.getId() );
        estoque.setIdFilial( dto.getIdFilial() );
        estoque.setIdProduto( dto.getIdProduto() );
        estoque.setQuantidade( dto.getQuantidade() );

        return estoque;
    }
}
