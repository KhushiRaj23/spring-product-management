package com.product.management.service;

import com.product.management.Product;
import com.product.management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public Product createProduct(Product product){
        if(product.getName()==null || product.getName().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
