package com.dev.produtosapi.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dev.produtosapi.model.Product;
import com.dev.produtosapi.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){
        product.setId(UUID.randomUUID().toString());
        return productRepository.save(product);
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProductById(String id){
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }
}
