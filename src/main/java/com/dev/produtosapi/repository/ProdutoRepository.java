package com.dev.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.produtosapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
