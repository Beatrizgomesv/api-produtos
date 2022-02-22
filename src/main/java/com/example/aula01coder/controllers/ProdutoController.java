package com.example.aula01coder.controllers;


import com.example.aula01coder.repositories.ProdutoRepository;
import com.example.aula01coder.repositories.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;


    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody
    Produto salvarProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;

    }

    @GetMapping
    public Iterable<Produto> obterProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
        return produtoRepository.findById(id);
    }


    @GetMapping(path = "/pagina/{numeropagina}")
    public Iterable<Produto> obterProdutosPorPagina(
            @PathVariable int numeroPagina) {
        Pageable page = PageRequest.of(0, 3);
        return produtoRepository.findAll(page);
    }

    @DeleteMapping(path = "/{id}")
    public void excluirProduto(@PathVariable int id) {
        produtoRepository.deleteById(id);
    }
}
