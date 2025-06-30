package com.dev.produtosapi.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.produtosapi.model.Produto;
import com.dev.produtosapi.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/criar")
    public Produto criarProduto(@RequestBody Produto produto) {
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        System.out.println("Produto criado com sucesso!" + produto.toString());
        return produto;
    }
    @GetMapping("/listar")
    public Produto listarProdutos() {
        return produtoRepository.findAll().get(0);
    }

    @GetMapping("/obter/{id}")
    public Produto obterProduto(@PathVariable String id) {
        return produtoRepository.findById(id).orElse(null);
    }

}
