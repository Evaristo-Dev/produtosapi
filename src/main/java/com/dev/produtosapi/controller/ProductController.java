package com.dev.produtosapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        produto.setId(UUID.randomUUID().toString());
        var salvo = produtoRepository.save(produto);
        System.out.println("Produto criado com sucesso!" + produto.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(String nome) {
        var produtos = produtoRepository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterProduto(@PathVariable String id) {
        return produtoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id ) {
        if (!produtoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable("id") String id, @RequestBody Produto produto){
        if (!produtoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        produto.setId(id);
        Produto atualizado = produtoRepository.save(produto);
        return ResponseEntity.ok(atualizado);
    }

}
