package com.rns.testes.java.dto.mapper;

import com.rns.testes.java.dto.ProdutoDto;
import com.rns.testes.java.model.Produto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-11T21:53:25-0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public ProdutoDto entityToDto(Produto entity) {
        if ( entity == null ) {
            return null;
        }

        ProdutoDto produtoDto = new ProdutoDto();

        if ( entity.getId() != null ) {
            produtoDto.setId( String.valueOf( entity.getId() ) );
        }
        produtoDto.setNome( entity.getNome() );

        return produtoDto;
    }

    @Override
    public Produto dtoToEntity(ProdutoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Produto produto = new Produto();

        if ( dto.getId() != null ) {
            produto.setId( Long.parseLong( dto.getId() ) );
        }
        produto.setNome( dto.getNome() );

        return produto;
    }
}
