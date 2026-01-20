package com.dev.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.produtosapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
