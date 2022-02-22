package com.example.aula01coder.repositories;

import com.example.aula01coder.repositories.entities.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository
        extends PagingAndSortingRepository<Produto, Integer> {

}
