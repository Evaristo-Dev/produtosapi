package com.dev.produtosapi.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.*;

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
        return produtoRepository.findAll().getFirst();
    }

    @GetMapping("/obter/{id}")
    public Produto obterProduto(@PathVariable String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable("id") String id ){
        produtoRepository.deleteById(id);
    }

}
